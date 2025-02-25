package com.eryi.bean.bo.pay.order;

import com.eryi.bean.bo.pay.RefundTransection;
import com.eryi.bean.bo.common.User;
import com.eryi.bean.bo.pay.PayTransection;
import com.eryi.bean.bo.shop.Shop;
import com.eryi.bean.dto.OrderItemDto;
import com.eryi.dao.OrderDao;
import lombok.*;

import java.io.Serializable;
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
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private OrderDao orderDao;
    /**
     * ����
     */
    private String id;
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
     * ������
     */
    private List<OrderItem> orderItems;
    /**
     * ״̬
     * 1.δ֧�� 2.��֧�� 3.�ѷ��� 4.���ջ� 5.���˿� 6.��ȡ��
     */
    private int status;

    /**
     * ֧������
     * 1.֧���� 2.΢�� 3.����
     */
    private int channel;

    /**
     * �ܼ۸�
     */
    private BigDecimal totalPrice;

    /**
     * ���˷�
     */
    private BigDecimal totalShipingFee;

    public int addOrderItem(OrderItem orderItem) {
        return orderDao.addOrderItem(orderItem);
    }
}
