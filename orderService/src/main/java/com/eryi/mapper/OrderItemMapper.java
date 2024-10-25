package com.eryi.mapper;

import com.eryi.domain.Order;
import com.eryi.domain.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderItemMapper {
    int addOrderItem(OrderItem orderItem);
    List<OrderItem> getOrderItemsByOrderId(String orderId);
    Order c(String id);
}
