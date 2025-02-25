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

    /**
     * ֧������
     */
    private String payTransectionId;
    /**
     * �˿��
     */
    private String refundTransectionId;
}
