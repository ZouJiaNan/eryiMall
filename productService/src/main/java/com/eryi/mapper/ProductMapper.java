package com.eryi.mapper;

import com.eryi.bo.Product;
import com.eryi.bo.query.ProductQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper{
    int addProduct(Product product);
    Product getProductById(String id);

    int deleteProductById(String id);

    int updateProduct(Product product);

    List<Product> getProductList(ProductQuery productQuery);
}
