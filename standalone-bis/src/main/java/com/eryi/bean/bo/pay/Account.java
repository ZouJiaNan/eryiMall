package com.eryi.bean.bo.pay;

import com.eryi.bean.bo.shop.Shop;

public class Account {
    private String id;
    /**
     * 商铺
     */
    private Shop shop;
    /**
     * 平台
     */
    private String channel;
    /**
     * 应用id
     */
    private String appId;
    /**
     * 私钥
     */
    private String privateKey;
    /**
     * 公钥
     */
    private String publicKey;
    /**
     * openId
     */
    private String openId;
    /**
     * 分账账户
     */
    private Account account;
}
