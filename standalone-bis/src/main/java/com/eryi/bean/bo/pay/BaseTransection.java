package com.eryi.bean.bo.pay;

/**
 * 交易基类
 */
public abstract class BaseTransection {
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
}
