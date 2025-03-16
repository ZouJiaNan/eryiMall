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
     * 唯一标识
     */
    private String id;
    /**
     * 排序编号
     */
    private int orderNum;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 数量
     */
    private int amount;
    /**
     * 剩余数量
     */
    private int remain;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 上架状态
     */
    private int listingStatus;

    /**
     * 标准库存单元编码
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
