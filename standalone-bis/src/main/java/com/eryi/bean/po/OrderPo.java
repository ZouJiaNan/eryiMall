package com.eryi.bean.po;

import com.eryi.bean.bo.common.User;
import com.eryi.bean.bo.pay.PayTransection;
import com.eryi.bean.bo.pay.RefundTransection;
import com.eryi.bean.bo.pay.order.LogisticsNews;
import com.eryi.bean.bo.pay.order.OrderItem;
import com.eryi.bean.bo.shop.Shop;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderPo {
    /**
     * ����
     */
    private String id;
    /**
     * �û�
     */
    private String userId;
    /**
     * ����
     */
    private String shopId;
    /**
     * �ջ���ַ
     */
    private String address;
    /**
     * ֧������
     */
    private String payTransectionId;
    /**
     * �˿��
     */
    private String refundTransectionId;

    /**
     * ״̬
     * 1.δ֧�� 2.��֧�� 3.�ѷ��� 4.���ջ� 5.���˿� 6.��ȡ��
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
