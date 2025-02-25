package com.eryi.mapper;

import com.eryi.bean.bo.pay.order.Order;
import com.eryi.bean.po.OrderPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    Order findOrderById(String userId);
    int addOrder(OrderPo orderPo);
}
