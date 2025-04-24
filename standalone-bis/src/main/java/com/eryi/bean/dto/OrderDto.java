package com.eryi.bean.dto;

import com.eryi.bean.bo.common.User;
import com.eryi.bean.bo.pay.PayTransection;
import com.eryi.bean.bo.pay.RefundTransection;
import com.eryi.bean.bo.pay.order.LogisticsNews;
import com.eryi.bean.bo.pay.order.OrderItem;
import com.eryi.bean.bo.shop.Shop;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {
    private String orderNum;
    private String remark;
    private BigDecimal totalPrice;
    /**
     * 用户
     */
    private String userId;
    /**
     * 商铺
     */
    private String shopId;
    /**
     * 收货地址
     */
    private String address;
    /**
     * 状态
     */
    private int status;
    /**
     * 运费
     */
    private BigDecimal shipingFee;
    /**
     * 数量
     */
    private int totalCount;

    /**
     * 销售消息列表
     */
    List<OrderItemDto> orderItems;
}
