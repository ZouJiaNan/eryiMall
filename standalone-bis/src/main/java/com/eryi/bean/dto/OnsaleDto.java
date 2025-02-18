package com.eryi.bean.dto;

import com.eryi.bean.bo.product.Product;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OnsaleDto {
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
    private String productId;
    /**
     *�ۼ�
     */
    private BigDecimal salePrice;
}
