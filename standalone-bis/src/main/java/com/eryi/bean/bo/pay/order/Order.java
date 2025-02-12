package com.eryi.bean.bo.pay.order;

import com.eryi.bean.bo.pay.RefundTransection;
import com.eryi.bean.bo.common.User;
import com.eryi.bean.bo.pay.PayTransection;
import com.eryi.bean.bo.shop.Shop;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * ����
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    /**
     * �û�
     */
    private User user;
    /**
     * ����
     */
    private Shop shop;
    /**
     * �ջ���ַ
     */
    private String address;
    /**
     * ֧������
     */
    private PayTransection payTransection;
    /**
     * �˿��
     */
    private RefundTransection refundTransection;
    /**
     * ������
     */
    private List<OrderItem> orderItems;
    /**
     * ״̬
     */
    private int status;

    /**
     * ������Ϣ
     */
    private LogisticsNews logisticsNews;

    /**
     * �˷�
     */
    private BigDecimal shipingFee;
}
