package com.eryi.service;

import com.eryi.bo.Order;
import com.eryi.bo.query.OrderQuery;

import java.util.List;

public interface OrderService {
    Order getOrderById(String id);
    List<Order> getOrderList(OrderQuery orderQuery);
    int addOrder(Order order);
    int updateOrder(Order order);
    int deleteOrder(String id);
}
