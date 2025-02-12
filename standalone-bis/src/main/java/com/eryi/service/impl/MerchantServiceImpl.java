package com.eryi.service.impl;

import com.eryi.bean.bo.product.Product;
import com.eryi.bean.dto.ProductDto;
import com.eryi.dao.ProductDao;
import com.eryi.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    ProductDao productDao;
    @Override
    public int addProduct(Product product) {
        ProductDto productDto = new ProductDto(product.getCategory().getId(),product.getTags(),product.getSpecs(),product.getShipingFeeTemp().getId(),product.getName());
        return productDao.addProduct(productDto);
    }
}
