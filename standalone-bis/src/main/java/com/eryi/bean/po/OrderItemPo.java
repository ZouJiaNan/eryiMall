package com.eryi.bean.po;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemPo {
    private String id;
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 商铺销售消息
     */
    private String onSaleId;
    /**
     * 总价
     */
    private BigDecimal totalPrice;
    /**
     * 数量
     */
    private int count;
    /**
     * 运费
     */
    private BigDecimal shipingFee;

    /**
     * 支付交易
     */
    private String payTransectionId;
    /**
     * 退款交易
     */
    private String refundTransectionId;
}
