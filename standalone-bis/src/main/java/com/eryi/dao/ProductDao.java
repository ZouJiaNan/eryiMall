package com.eryi.dao;

import com.alibaba.fastjson.JSON;
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
        productPo.setTags(product.getTags());
        productPo.setPlatformDivision(product.getPlatformDivision());
        return productMapper.addProduct(productPo);
    }

    public int editProduct(Product product){
        return productMapper.editProduct(BoToPo(product));
    }

    public Product getProductById(String id){
        return productMapper.getProductById(id);
    }

    public List<Product> findAll(){
        return productMapper.findAll();
    }

    public List<Product> getProducts(ProductPo productPo){return productMapper.getProducts(productPo);}

    public int addSPU(String productId,String spuJson){
        Product product=productMapper.getProductById(productId);
        ProductPo productPo = BoToPo(product);
        productPo.setSpu(spuJson);
        return productMapper.editProduct(productPo);
    }
    public int addSKU(String productId,String skuJson){
        Product product=productMapper.getProductById(productId);
        ProductPo productPo = BoToPo(product);
        productPo.setSku(skuJson);
        return productMapper.editProduct(productPo);
    }
    private ProductPo BoToPo(Product product){
        ProductPo productPo=new ProductPo();
        productPo.setId(product.getId());
        productPo.setName(product.getName());
        productPo.setTags(product.getTags());
        productPo.setPlatformDivision(product.getPlatformDivision());
        return productPo;
    }
}
