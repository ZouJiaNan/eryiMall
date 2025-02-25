package com.eryi.mapper;

import com.eryi.bean.bo.pay.order.OrderItem;
import com.eryi.bean.po.OrderItemPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderItemMapper {
    int addOrderItem(OrderItemPo orderItemPo);
}
