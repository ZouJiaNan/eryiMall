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
     * ��ӹ��ﳵ
     * @param userId
     * @param productId
     * @return
     */
    @Override
    @Transactional
    public int addCarItem(String userId,String productId) {
        //��ȡ��Ѫģ��
        Car car = carDao.findByUserId(userId);
        //��ӹ��ﳵ
        return car.addCarItem(car.getId(),productId);
    }

    /**
     * ��������
     * @param order
     * @return
     */
    @Override
    @Transactional
    public Order createOrder(Order order) {
        //�������
        String skuCode = order.getOrderItems().get(0).getProduct().getSkus().get(0).getSkuCode();
        String productId = order.getOrderItems().get(0).getProduct().getId();
        OnSale onSale = onSaleDao.findBySkuCodeAndProductId(productId,skuCode);
        onSale.lockStock(order);

        CompletableFuture<Object> future1 = new CompletableFuture<>();
        CompletableFuture<Void> future2 = new CompletableFuture<>();
        //������Сʱ��ʱ��Ϣ
        createOrderdelayed(future1,order);
        //�����߳�,������������д���߳��ϸ��ڴ�����ʱ��Ϣ���߳�ִ����ɺ���ִ��
        future1.thenCompose(delayResult-> createOrder(future2,order));
        return order;
    }

    private CompletableFuture createOrder(CompletableFuture future,Order order){
        //д�����������
        Message<Order> message = MessageBuilder.withPayload(order)
                .build();
        rocketMQTemplate.asyncSend(orderTopic, message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("д����������гɹ���" + sendResult.toString());
                future.complete(null);
            }
            @Override
            public void onException(Throwable throwable) {
                System.out.println("д�����������ʧ�ܣ�" + throwable.getMessage());
                future.completeExceptionally(throwable);
            }
        });
        return future;
    }

    private CompletableFuture createOrderdelayed(CompletableFuture future,Order order){
        //д��ʱ����
        Message<Order> delayedMessage = MessageBuilder.withPayload(order).build();
        rocketMQTemplate.asyncSend(orderDelayedTopic, delayedMessage, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("д�ӳٶ��гɹ���" + sendResult.toString());
                future.complete(null);
            }
            @Override
            public void onException(Throwable throwable) {
                System.out.println("д�ӳٶ���ʧ�ܣ�" + throwable.getMessage());
                future.completeExceptionally(throwable);
            }
        },3000,1);
        return future;
    }

    /**
     * �����������
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
