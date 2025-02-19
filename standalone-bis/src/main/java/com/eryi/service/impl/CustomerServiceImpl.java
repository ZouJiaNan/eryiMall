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
     * ��ӹ��ﳵ
     * @param userId
     * @param onSaleId
     * @return
     */
    @Override
    @Transactional
    public int addCarItem(String userId,String onSaleId) {
        //��ȡ��Ѫģ��
        Car car = carDao.findByUserId(userId);
        //��ӹ��ﳵ
        return car.addCarItem(car.getId(),onSaleId);
    }

    /**
     * ��������
     * @param carItem
     * @return
     */
    @Override
    public int createOrder(CarItem carItem) {
        //��������ʵ��
        //��Ϊ�ǻ�û��������Դ�������Bo��֧�������ʱ��תΪPo
        Order order = new Order();
        OrderItem orderItem = new OrderItem();
        orderItem.setOnSale(carItem.getOnSale());
        order.getOrderItems().add(orderItem);
        //����MQ
        return 0;
    }

    @Override
    public List<OnSale> getOnSaleList(String userId) {
        return onSaleDao.getOnSaleList(userId);
    }
}
