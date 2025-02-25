package com.eryi.dao;

import com.eryi.bean.bo.pay.order.Order;
import com.eryi.bean.bo.pay.order.OrderItem;
import com.eryi.bean.po.OrderItemPo;
import com.eryi.bean.po.OrderPo;
import com.eryi.mapper.OrderItemMapper;
import com.eryi.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderItemMapper orderItemMapper;

    private Order build(Order order){
        order.setOrderDao(this);
        return order;
    }

    public Order findOrderById(String id) {
        return build(orderMapper.findOrderById(id));
    }

    public int addOrder(Order order) {
        return orderMapper.addOrder(OrderBoToPo(order));
    }

    public int addOrderItem(OrderItem orderItem) {
        return orderItemMapper.addOrderItem(ItemBoToPo(orderItem));
    }

    private OrderItemPo ItemBoToPo(OrderItem orderItem){
        OrderItemPo orderItemPo = new OrderItemPo();
        orderItemPo.setId(orderItem.getId());
        orderItemPo.setOrderId(orderItem.getOrderId());
        orderItemPo.setOnSaleId(orderItem.getOnSale().getId());
        orderItemPo.setTotalPrice(orderItem.getTotalPrice());
        orderItemPo.setCount(orderItem.getCount());
        orderItemPo.setShipingFee(orderItem.getShipingFee());
        return  orderItemPo;
    }

    private OrderPo OrderBoToPo(Order order){
        OrderPo orderPo = new OrderPo();
        orderPo.setId(order.getId());
        orderPo.setShopId(order.getShop().getId());
        orderPo.setAddress(order.getAddress());
        return orderPo;
    }
}
