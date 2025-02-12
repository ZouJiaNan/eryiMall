package com.eryi.mapper;

import com.eryi.bean.bo.product.Product;
import com.eryi.bean.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    int addProduct(ProductDto productDto);

    Product getProductById(String productId);
}
