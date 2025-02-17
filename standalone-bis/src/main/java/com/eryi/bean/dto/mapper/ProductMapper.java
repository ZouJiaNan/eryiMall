package com.eryi.bean.dto.mapper;

import com.eryi.bean.bo.product.Product;
import com.eryi.bean.dto.ProductDto;
import com.eryi.bean.po.ProductPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    int addProduct(ProductPo productPo);

    Product getProductById(String productId);
}
