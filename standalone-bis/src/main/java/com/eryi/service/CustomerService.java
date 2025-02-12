package com.eryi.service;

import com.eryi.bean.bo.customer.CarItem;

public interface CustomerService {
    /**
     * 添加购物车
     * @param userId
     * @param onSaleId
     * @return
     */
    int addCarItem(String userId,String onSaleId);

    /**
     * 创建订单
     * @param carItem
     * @return
     */
    int createOrder(CarItem carItem);
}
