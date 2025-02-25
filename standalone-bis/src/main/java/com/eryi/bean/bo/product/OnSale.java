package com.eryi.bean.bo.product;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OnSale {
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
     * ��Ʒ
     */
    private Product product;
    private BigDecimal salePrice;

    public OnSale(String id){
        this.id=id;
    }
}
