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
     * ����id
     */
    private String orderId;
    /**
     * ����������Ϣ
     */
    private Product product;
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
    private PayTransection payTransection;
    /**
     * �˿��
     */
    private RefundTransection refundTransection;

    /**
     * ������Ϣ
     */
    private LogisticsNews logisticsNews;
}
