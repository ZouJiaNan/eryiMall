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
     * 销售信息id
     */
    private String onSaleId;
    /**
     * 商品id
     */
    private String productId;
    /**
     * sku
     */
    private String skuCode;
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
