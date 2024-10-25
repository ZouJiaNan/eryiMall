package com.eryi.service;

import com.eryi.domain.Product;
import com.eryi.domain.query.ProductQuery;

import java.util.List;

public interface ProductService {
    Product getProductById(String id);

    List<Product> getProductList(ProductQuery productQuery);
    int addProduct(Product product);
    public int deleteProductById(String id);
    int updateProduct(Product product);
}
