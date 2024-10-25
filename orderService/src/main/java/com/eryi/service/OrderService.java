package com.eryi.service;

import com.eryi.domain.Order;
import com.eryi.domain.query.OrderQuery;

import java.util.List;

public interface OrderService {
    Order getOrderById(String id);
    List<Order> getOrderList(OrderQuery orderQuery);
    int addOrder(Order order);
    int updateOrder(Order order);
    int deleteOrder(String id);
}
