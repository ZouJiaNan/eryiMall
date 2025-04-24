package com.eryi.service.impl;

import com.eryi.bean.bo.customer.Car;
import com.eryi.bean.bo.pay.order.Order;
import com.eryi.bean.bo.pay.order.OrderItem;
import com.eryi.bean.bo.product.Category;
import com.eryi.bean.bo.product.OnSale;
import com.eryi.bean.bo.product.Product;
import com.eryi.bean.po.CategoryPo;
import com.eryi.bean.po.ProductPo;
import com.eryi.dao.*;
import com.eryi.service.CustomerService;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CarDao carDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    OnSaleDao onSaleDao;

    @Autowired
    OrderDao orderDao;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    AlipayServiceImpl alipayService;

    @Value("${my.topic.order.delayed}")
    private String orderDelayedTopic;

    @Value("${my.topic.order}")
    private String orderTopic;

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    /**
     * 添加购物车
     * @param userId
     * @param productId
     * @return
     */
    @Override
    @Transactional
    public int addCarItem(String userId,String productId) {
        //获取满血模型
        Car car = carDao.findByUserId(userId);
        //添加购物车
        return car.addCarItem(car.getId(),productId);
    }

    /**
     * 创建订单
     * @param order
     * @return
     */
    @Override
    @Transactional
    public Order createOrder(Order order) {
        //锁定库存
        String skuCode = order.getOrderItems().get(0).getProduct().getSkus().get(0).getSkuCode();
        String productId = order.getOrderItems().get(0).getProduct().getId();
        OnSale onSale = onSaleDao.findBySkuCodeAndProductId(productId,skuCode);
        onSale.lockStock(order);

        CompletableFuture<Object> future1 = new CompletableFuture<>();
        CompletableFuture<Void> future2 = new CompletableFuture<>();
        //创建半小时延时消息
        createOrderdelayed(future1,order);
        //编排线程,创建订单，让写库线程严格在创建延时消息的线程执行完成后再执行
        future1.thenCompose(delayResult-> createOrder(future2,order));
        return order;
    }

    private CompletableFuture createOrder(CompletableFuture future,Order order){
        //写流量削峰队列
        Message<Order> message = MessageBuilder.withPayload(order)
                .build();
        rocketMQTemplate.asyncSend(orderTopic, message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("写流量削峰队列成功：" + sendResult.toString());
                future.complete(null);
            }
            @Override
            public void onException(Throwable throwable) {
                System.out.println("写流量削峰队列失败：" + throwable.getMessage());
                future.completeExceptionally(throwable);
            }
        });
        return future;
    }

    private CompletableFuture createOrderdelayed(CompletableFuture future,Order order){
        //写延时队列
        Message<Order> delayedMessage = MessageBuilder.withPayload(order).build();
        rocketMQTemplate.asyncSend(orderDelayedTopic, delayedMessage, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("写延迟队列成功：" + sendResult.toString());
                future.complete(null);
            }
            @Override
            public void onException(Throwable throwable) {
                System.out.println("写延迟队列失败：" + throwable.getMessage());
                future.completeExceptionally(throwable);
            }
        },3000,1);
        return future;
    }

    /**
     * 订单新增落库
     * @param order
     * @return
     */
    @Transactional
    public int addOrder(Order order) {
        orderDao.addOrder(order);
        Order findOrder=orderDao.findOrderById(order.getId());
        for (OrderItem orderItem : order.getOrderItems()) {
            orderItem.setOrderId(order.getId());
            findOrder.addOrderItem(orderItem);
        }
        return 1;
    }

    @Override
    public List<OnSale> getOnSaleList(String userId) {
        return onSaleDao.getOnSaleList(userId);
    }

    @Override
    public List<Product> getProducts(String categoryId,String name) {
        ProductPo productPo=new ProductPo();
        productPo.setCategoryId(categoryId);
        return productDao.getProducts(productPo);
    }

    @Override
    public Product getProductDetail(String productId) {
        return productDao.getProductDetail(productId);
    }

    @Override
    public List<Category> getCategorys(CategoryPo categoryPo) {
        return categoryDao.getCategorys(categoryPo);
    }

    @Override
    public String genernatePCAlipayHtml(Order order) {
        return alipayService.genernatePCAlipayHtml(order);
    }
}
