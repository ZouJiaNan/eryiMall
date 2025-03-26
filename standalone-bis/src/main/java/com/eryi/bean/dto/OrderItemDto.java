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
     * ����id
     */
    private String orderId;
    /**
     * ������Ϣid
     */
    private String onSaleId;
    /**
     * ��Ʒid
     */
    private String productId;
    /**
     * sku
     */
    private String skuCode;
    /**
     * �ܼ�
     */
    private BigDecimal totalPrice;
    /**
     * ����
     */
    private int count;
    /**
     * �˷�
     */
    private BigDecimal shipingFee;
}
