package com.eryi.bean.po;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OnSalePo {
    /**
     * Ψһ��ʶ
     */
    private String id;
    /**
     * ������
     */
    private int orderNum;
    /**
     * �۸�
     */
    private BigDecimal price;
    /**
     * ����
     */
    private int amount;
    /**
     * ʣ������
     */
    private int remain;
    /**
     * ��ʼʱ��
     */
    private Date startTime;
    /**
     * ����ʱ��
     */
    private Date endTime;
    /**
     * �ϼ�״̬
     */
    private int listingStatus;
    /**
     * ���ۼ�
     */
    private BigDecimal salePrice;
    /**
     * sku����
     */
    private String skuCode;
    /**
     * ��Ʒid
     */
    private String productId;
}
