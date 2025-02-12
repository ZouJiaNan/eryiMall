package com.eryi.dao;

import com.eryi.bean.bo.product.Product;
import com.eryi.bean.dto.ProductDto;
import com.eryi.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
    @Autowired
    ProductMapper productMapper;


    public int addProduct(ProductDto productDto){
        return productMapper.addProduct(productDto);
    }

    public Product getProductById(String id){
        return productMapper.getProductById(id);
    }
}
