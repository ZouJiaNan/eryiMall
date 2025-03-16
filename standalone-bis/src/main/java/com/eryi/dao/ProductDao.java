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

    private ProductPo BoToPo(Product product){
        ProductPo productPo=new ProductPo();
        productPo.setId(product.getId());
        productPo.setSpecs(product.getSpu().getSpes().toString());
        productPo.setName(product.getName());
        productPo.setTags(product.getTags());
        productPo.setPlatformDivision(product.getPlatformDivision());
//        productPo.setAssociatedProdIds(product.getAssociatedProdIds());
//        productPo.setCouponDiscountId(product.getCouponDiscountId());
//        productPo.setShipingFeeTempId(product.getShipingFeeTempId());
//        productPo.setShopId(product.getShop().getId());
        productPo.setSpu(product.getSpu().toString());
        productPo.setSku(product.getSpu().getSkus().toString());
        return productPo;
    }
}
