package com.eryi.dao;

import com.eryi.bean.bo.product.Product;
import com.eryi.bean.po.ProductPo;
import com.eryi.bean.dto.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
    @Autowired
    ProductMapper productMapper;


    public int addProduct(Product product){
        ProductPo productPo = new ProductPo();
        productPo.setId(product.getId());
        productPo.setCategoryId(product.getCategory().getId());
        return productMapper.addProduct(productPo);
    }

    public Product getProductById(String id){
        return productMapper.getProductById(id);
    }
}
