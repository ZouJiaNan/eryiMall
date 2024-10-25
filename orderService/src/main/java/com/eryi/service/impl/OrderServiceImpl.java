package com.eryi.service.impl;

import com.eryi.domain.Order;
import com.eryi.domain.query.OrderQuery;
import com.eryi.mapper.OrderMapper;
import com.eryi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Override
    public Order getOrderById(String id) {
        return orderMapper.getOrderById(id);
    }

    @Override
    public List<Order> getOrderList(OrderQuery orderQuery) {
        return orderMapper.getOrderList(orderQuery);
    }

    @Override
    public int addOrder(Order order) {
        return orderMapper.addOrder(order);
    }

    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateOrder(order);
    }

    @Override
    public int deleteOrder(String id) {
        return orderMapper.deleteOrder(id);
    }
}
