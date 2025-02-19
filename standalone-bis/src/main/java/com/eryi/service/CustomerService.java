package com.eryi.service;

import com.eryi.bean.bo.customer.CarItem;
import com.eryi.bean.bo.product.OnSale;
import com.eryi.bean.bo.product.Product;

import java.util.List;

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

    /**
     *获取商品列表
     * @return
     */
    List<OnSale> getOnSaleList(String userId);


}
