package com.eryi.service;

import com.eryi.bean.bo.pay.order.Order;
import com.eryi.bean.bo.product.Category;
import com.eryi.bean.bo.product.OnSale;
import com.eryi.bean.bo.product.Product;
import com.eryi.bean.po.CategoryPo;

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

    /**
     * ��ȡ��Ʒ�б�
     * @return
     */
    List<Product> getProducts(String categoryId,String name);

    Product getProductDetail(String productId);

    /**
     * ��ȡ��Ʒ�����б�
     * @return
     */
    List<Category> getCategorys(CategoryPo categoryPo);
}
