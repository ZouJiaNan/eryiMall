package com.eryi.service.impl;

import com.eryi.domain.Product;
import com.eryi.domain.query.ProductQuery;
import com.eryi.mapper.ProductMapper;
import com.eryi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product getProductById(String id) {
        return productMapper.getProductById(id);
    }

    @Override
    public List<Product> getProductList(ProductQuery productQuery) {
        return productMapper.getProductList(productQuery);
    }


    @Override
    public int addProduct(Product product) {
        return productMapper.addProduct(product);
    }

    @Override
    public int deleteProductById(String id) {
        return productMapper.deleteProductById(id);
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }
}
