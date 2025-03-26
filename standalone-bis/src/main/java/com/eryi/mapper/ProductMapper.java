package com.eryi.mapper;

import com.eryi.bean.bo.product.Product;
import com.eryi.bean.dto.ProductDto;
import com.eryi.bean.po.ProductPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    int addProduct(ProductPo productPo);
    Product getProductById(String productId);
    List<Product> findAll();
    List<Product> getProducts(ProductPo productPo);
    Product getProductDetail(String productId);
    int editProduct(ProductPo productPo);
    int addSPU(String spuJson);
}
