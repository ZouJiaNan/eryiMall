package com.eryi.bo;

import java.math.BigDecimal;

public class Inventory {
    private String id;
    private String productId;

    //确认库存量
    private String actualStock;
    //锁定库存(订单未支付)
    private String lockStock;
    //待入库库存
    private String pendingInStock;
    //待出库库存(订单已支付)
    private String pendingOutStock;
    //库存告警线(商品低于该数量提醒采购)
    private int warmUpLine;
    //进货价
    private BigDecimal inStcokPrice;
    //出货价
    private BigDecimal outStcokPrice;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getActualStock() {
        return actualStock;
    }

    public void setActualStock(String actualStock) {
        this.actualStock = actualStock;
    }

    public String getLockStock() {
        return lockStock;
    }

    public void setLockStock(String lockStock) {
        this.lockStock = lockStock;
    }

    public String getPendingInStock() {
        return pendingInStock;
    }

    public void setPendingInStock(String pendingInStock) {
        this.pendingInStock = pendingInStock;
    }

    public String getPendingOutStock() {
        return pendingOutStock;
    }

    public void setPendingOutStock(String pendingOutStock) {
        this.pendingOutStock = pendingOutStock;
    }

    public int getWarmUpLine() {
        return warmUpLine;
    }

    public void setWarmUpLine(int warmUpLine) {
        this.warmUpLine = warmUpLine;
    }

    public BigDecimal getInStcokPrice() {
        return inStcokPrice;
    }

    public void setInStcokPrice(BigDecimal inStcokPrice) {
        this.inStcokPrice = inStcokPrice;
    }

    public BigDecimal getOutStcokPrice() {
        return outStcokPrice;
    }

    public void setOutStcokPrice(BigDecimal outStcokPrice) {
        this.outStcokPrice = outStcokPrice;
    }
}
