package com.eryi.service.impl;

import com.eryi.bean.bo.customer.Car;
import com.eryi.bean.bo.customer.CarItem;
import com.eryi.bean.bo.pay.order.Order;
import com.eryi.bean.bo.pay.order.OrderItem;
import com.eryi.bean.bo.product.OnSale;
import com.eryi.bean.bo.product.Product;
import com.eryi.dao.CarDao;
import com.eryi.dao.OnSaleDao;
import com.eryi.dao.ProductDao;
import com.eryi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
     * @param carItem
     * @return
     */
    @Override
    public int createOrder(CarItem carItem) {
        //创建订单实体
        //因为是还没有落库所以创建的是Bo，支付后落库时再转为Po
        Order order = new Order();
        OrderItem orderItem = new OrderItem();
        orderItem.setOnSale(carItem.getOnSale());
        order.getOrderItems().add(orderItem);
        //交给MQ
        return 0;
    }

    @Override
    public List<OnSale> getOnSaleList(String userId) {
        return onSaleDao.getOnSaleList(userId);
    }
}
