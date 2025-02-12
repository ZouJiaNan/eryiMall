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
     * ����id
     */
    private String orderId;
    /**
     * ����������Ϣ
     */
    private OnSale onSale;
    /**
     * �ܼ�
     */
    private BigDecimal totalPrice;
    /**
     * ����
     */
    private BigDecimal count;
    /**
     * �˷�
     */
    private BigDecimal shipingFee;
}
