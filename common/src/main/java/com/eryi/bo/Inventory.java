package com.eryi.bo;

import java.math.BigDecimal;

public class Inventory {
    private String id;
    private String productId;

    //ȷ�Ͽ����
    private String actualStock;
    //�������(����δ֧��)
    private String lockStock;
    //�������
    private String pendingInStock;
    //��������(������֧��)
    private String pendingOutStock;
    //���澯��(��Ʒ���ڸ��������Ѳɹ�)
    private int warmUpLine;
    //������
    private BigDecimal inStcokPrice;
    //������
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
