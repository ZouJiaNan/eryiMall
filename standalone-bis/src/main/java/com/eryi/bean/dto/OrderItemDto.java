package com.eryi.bean.dto;

import com.eryi.bean.bo.product.OnSale;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItemDto {
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
}
