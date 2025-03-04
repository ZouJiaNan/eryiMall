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
     * ����������Ϣ
     */
    private String onSaleId;
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
