package com.eryi.bean.bo.product;

import com.eryi.bean.bo.pay.order.Order;
import com.eryi.dao.OnSaleDao;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OnSale {
    private OnSaleDao onSaleDao;
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
     * ��׼��浥Ԫ����
     */
    private String skuCode;
    private BigDecimal salePrice;

    public OnSale(String id){
        this.id=id;
    }

    public void lockStock(Order order){
        order.getOrderItems().forEach(orderItem -> {
            onSaleDao.lockStock(this,orderItem.getCount());
        });
    }

    public void releaseStock(Order order){
        order.getOrderItems().forEach(orderItem -> {
            onSaleDao.releaseStock(this,orderItem.getCount());
        });
    }
}
