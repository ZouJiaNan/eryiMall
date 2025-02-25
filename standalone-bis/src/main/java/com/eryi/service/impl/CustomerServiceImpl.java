package com.eryi.service.impl;

import com.eryi.bean.bo.customer.Car;
import com.eryi.bean.bo.customer.CarItem;
import com.eryi.bean.bo.pay.order.Order;
import com.eryi.bean.bo.pay.order.OrderItem;
import com.eryi.bean.bo.product.OnSale;
import com.eryi.bean.bo.product.Product;
import com.eryi.dao.CarDao;
import com.eryi.dao.OnSaleDao;
import com.eryi.dao.OrderDao;
import com.eryi.dao.ProductDao;
import com.eryi.service.CustomerService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Value("${my.topic.order.delayed}")
    private String orderDelayedTopic;

    @Value("${my.topic.order}")
    private String orderTopic;

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    /**
     * 添加购物车
     * @param userId
     * @param onSaleId
     * @return
     */
    @Override
    @Transactional
    public int addCarItem(String userId,String onSaleId) {
        //获取满血模型
        Car car = carDao.findByUserId(userId);
        //添加购物车
        return car.addCarItem(car.getId(),onSaleId);
    }

    /**
     * 创建订单
     * @param order
     * @return
     */
    @Override
    public int createOrder(Order order) {
        //交给MQ
        //延时队列
        rocketMQTemplate.convertAndSend(orderDelayedTopic,order);
        //写库队列
        rocketMQTemplate.convertAndSend(orderTopic,order);
        return 1;
    }

    /**
     * 订单新增落库
     * @param order
     * @return
     */
    public int addOrder(Order order) {
        orderDao.addOrder(order);
        order=orderDao.findOrderById(order.getId());
        for (OrderItem orderItem : order.getOrderItems()) {
            order.addOrderItem(orderItem);
        }
        return 1;
    }

    @Override
    public List<OnSale> getOnSaleList(String userId) {
        return onSaleDao.getOnSaleList(userId);
    }
}
