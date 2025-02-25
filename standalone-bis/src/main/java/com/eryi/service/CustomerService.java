package com.eryi.service;

import com.eryi.bean.bo.pay.order.Order;
import com.eryi.bean.bo.product.OnSale;

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
     * @param order
     * @return
     */
    int createOrder(Order order);

    /**
     * �����������
     * @param order
     * @return
     */
    int addOrder(Order order);

    /**
     *��ȡ��Ʒ�б�
     * @return
     */
    List<OnSale> getOnSaleList(String userId);

}
