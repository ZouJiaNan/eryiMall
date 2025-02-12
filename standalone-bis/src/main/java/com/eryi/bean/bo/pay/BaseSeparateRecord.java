package com.eryi.bean.bo.pay;

/**
 * 分账基类
 */
public class BaseSeparateRecord {
    /**
     * 流水号
     */
    private String serialNumber;
    /**
     * 交易量
     */
    private String amount;
    /**
     * 交易账户
     */
    private Account account;
    /**
     * 关联交易
     */
    private BaseTransection transection;
}
