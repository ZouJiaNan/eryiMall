package com.eryi.service;

import com.eryi.bean.bo.customer.CarItem;
import com.eryi.bean.bo.product.OnSale;
import com.eryi.bean.bo.product.Product;

import java.util.List;

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

    /**
     *��ȡ��Ʒ�б�
     * @return
     */
    List<OnSale> getOnSaleList(String userId);


}
