package com.eryi.controller;

import com.eryi.bo.Order;
import com.eryi.bo.query.OrderQuery;
import com.eryi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    public Order getOrderById(String id) {
        return orderService.getOrderById(id);
    }

    public List<Order> getOrderList(OrderQuery orderQuery) {
        return orderService.getOrderList(orderQuery);
    }

    public int addOrder(Order order) {
        return orderService.addOrder(order);
    }

    public int updateOrder(Order order) {
        return orderService.updateOrder(order);
    }

    public int deleteOrder(String id) {
        return orderService.deleteOrder(id);
    }
}
