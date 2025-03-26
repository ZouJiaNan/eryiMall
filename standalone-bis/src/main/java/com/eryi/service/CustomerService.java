package com.eryi.service;

import com.eryi.bean.bo.pay.order.Order;
import com.eryi.bean.bo.product.Category;
import com.eryi.bean.bo.product.OnSale;
import com.eryi.bean.bo.product.Product;
import com.eryi.bean.po.CategoryPo;

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
     * @param order
     * @return
     */
    int createOrder(Order order);

    /**
     * 订单新增落库
     * @param order
     * @return
     */
    int addOrder(Order order);

    /**
     *获取商品列表
     * @return
     */
    List<OnSale> getOnSaleList(String userId);

    /**
     * 获取商品列表
     * @return
     */
    List<Product> getProducts(String categoryId,String name);

    Product getProductDetail(String productId);

    /**
     * 获取商品分类列表
     * @return
     */
    List<Category> getCategorys(CategoryPo categoryPo);
}
