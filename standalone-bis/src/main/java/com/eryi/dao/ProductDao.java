package com.eryi.dao;

import com.eryi.bean.bo.product.Product;
import com.eryi.bean.po.ProductPo;
import com.eryi.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ProductDao {
    @Autowired
    ProductMapper productMapper;
    public int addProduct(Product product){
        ProductPo productPo = new ProductPo();
        productPo.setId(UUID.randomUUID().toString());
        productPo.setCategoryId(product.getCategory().getId());
        productPo.setName(product.getName());
        productPo.setSpecs(product.getSpecs());
        productPo.setTags(product.getTags());
        productPo.setPlatformDivision(product.getPlatformDivision());
        return productMapper.addProduct(productPo);
    }

    public Product getProductById(String id){
        return productMapper.getProductById(id);
    }

    public List<Product> findAll(){
        return productMapper.findAll();
    }
}
