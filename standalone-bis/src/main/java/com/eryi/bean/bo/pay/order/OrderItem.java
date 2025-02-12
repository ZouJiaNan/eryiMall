package com.eryi.bean.bo.pay.order;

import com.eryi.bean.bo.product.OnSale;
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
    private OnSale onSale;
    /**
     * 总价
     */
    private BigDecimal totalPrice;
    /**
     * 数量
     */
    private BigDecimal count;
    /**
     * 运费
     */
    private BigDecimal shipingFee;
}
