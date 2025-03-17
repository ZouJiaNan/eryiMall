package com.eryi.service;

import com.eryi.bean.bo.product.*;
import com.eryi.bean.bo.shop.ShipingFeeTemp;
import com.eryi.bean.dto.ShipingFeeTempDto;
import com.eryi.dao.ShipingFeeTempDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MerchantService {
    /**
     * 新增商品
     * @param product
     * @return
     */
    int addProduct(Product product);

    /**
     * 新增分类
     * @param category
     * @return
     */
    int addCategory(Category category);

    /**
     * 新增运费模板
     * @param shipingFeeTemp
     * @return
     */
    int addShipingFeeTemp(ShipingFeeTemp shipingFeeTemp);
    /**
     * 编辑销售信息
     * @param onSale
     * @return
     */
    int editOnSale(OnSale onSale);
    /**
     * 新增销售信息
     * @param onSale
     * @return
     */
    int addOnSale(OnSale onSale);
    /**
     * 获取运费模板列表
     * @param userId
     * @return
     */
    List<ShipingFeeTemp> getShipingFeeTempList(String userId);
    /**
     * 获取商品列表
     * @param userId
     * @return
     */
    List<Product> getProductList(String userId);
    /**
     * 新增SPU
     * @param spuJson
     * @return
     */
    int addSPU(String productId,String spuJson);

    /**
     * 新增SKU
     * @param productId
     * @param skuJson
     * @return
     */
    int addSKU(String productId,String skuJson);
}
