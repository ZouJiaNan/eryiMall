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
     * 销售价
     */
    private BigDecimal salePrice;
    /**
     * sku编码
     */
    private String skuCode;
    /**
     * 商品id
     */
    private String productId;
}
