package com.eryi.mapper;

import com.eryi.bean.bo.pay.order.Order;
import com.eryi.bean.po.OrderPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    Order findOrderByUserId(String userId);
    Order findOrderById(String id);
    int addOrder(OrderPo orderPo);
}
