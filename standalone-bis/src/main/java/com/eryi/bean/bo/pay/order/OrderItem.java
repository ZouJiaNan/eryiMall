package com.eryi.bean.bo.pay.order;

import com.eryi.bean.bo.pay.PayTransection;
import com.eryi.bean.bo.pay.RefundTransection;
import com.eryi.bean.bo.product.OnSale;
import com.eryi.bean.bo.product.Product;
import lombok.*;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItem {
    private String id;
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 商铺销售消息
     */
    private Product product;
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
    private PayTransection payTransection;
    /**
     * 退款交易
     */
    private RefundTransection refundTransection;

    /**
     * 物流消息
     */
    private LogisticsNews logisticsNews;
}
