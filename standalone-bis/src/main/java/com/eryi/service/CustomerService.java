package com.eryi.service;

import com.eryi.bean.bo.customer.CarItem;

public interface CustomerService {
    /**
     * ��ӹ��ﳵ
     * @param userId
     * @param onSaleId
     * @return
     */
    int addCarItem(String userId,String onSaleId);

    /**
     * ��������
     * @param carItem
     * @return
     */
    int createOrder(CarItem carItem);
}
