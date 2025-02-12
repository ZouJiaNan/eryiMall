package com.eryi.mapper;

import com.eryi.bo.Order;
import com.eryi.bo.query.OrderQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    Order getOrderById(String id);
    List<Order> getOrderList(OrderQuery orderQuery);
    int addOrder(Order order);
    int updateOrder(Order order);
    int deleteOrder(String id);
}
