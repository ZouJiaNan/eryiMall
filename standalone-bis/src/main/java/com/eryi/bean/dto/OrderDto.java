package com.eryi.bean.dto;

import com.eryi.bean.bo.common.User;
import com.eryi.bean.bo.pay.PayTransection;
import com.eryi.bean.bo.pay.RefundTransection;
import com.eryi.bean.bo.pay.order.LogisticsNews;
import com.eryi.bean.bo.pay.order.OrderItem;
import com.eryi.bean.bo.shop.Shop;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {
    private String orderNum;
    private String remark;
    private BigDecimal totalPrice;
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
     * ״̬
     */
    private int status;
    /**
     * �˷�
     */
    private BigDecimal shipingFee;
    /**
     * ����
     */
    private int totalCount;

    /**
     * ������Ϣ�б�
     */
    List<OrderItemDto> orderItems;
}
