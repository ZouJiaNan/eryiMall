package com.eryi.bean.bo.pay.order;

import com.eryi.bean.bo.pay.RefundTransection;
import com.eryi.bean.bo.common.User;
import com.eryi.bean.bo.pay.PayTransection;
import com.eryi.bean.bo.shop.Shop;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    /**
     * 用户
     */
    private User user;
    /**
     * 商铺
     */
    private Shop shop;
    /**
     * 收货地址
     */
    private String address;
    /**
     * 支付交易
     */
    private PayTransection payTransection;
    /**
     * 退款交易
     */
    private RefundTransection refundTransection;
    /**
     * 订单项
     */
    private List<OrderItem> orderItems;
    /**
     * 状态
     */
    private int status;

    /**
     * 物流消息
     */
    private LogisticsNews logisticsNews;

    /**
     * 运费
     */
    private BigDecimal shipingFee;
}
