package com.eryi.mapper;

import com.eryi.bean.bo.product.OnSale;
import com.eryi.bean.po.OnSalePo;
import com.eryi.dao.OnSaleDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OnSaleMapper {
    OnSale findBySkuCodeAndProductId(@Param("productId") String productId, @Param("skuCode") String skuCode);
    int addOnSale(OnSalePo onSalePo);
    int editOnSale(OnSalePo onSalePo);
    List<OnSale> getOnSaleList();

    List<OnSale> getProductsByCate(String categoryId);
}
