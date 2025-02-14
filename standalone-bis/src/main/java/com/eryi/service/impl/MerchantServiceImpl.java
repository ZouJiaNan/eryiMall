package com.eryi.service.impl;

import com.eryi.bean.bo.product.Category;
import com.eryi.bean.bo.product.Product;
import com.eryi.bean.bo.shop.ShipingFeeTemp;
import com.eryi.bean.dto.ProductDto;
import com.eryi.bean.dto.ResultBean;
import com.eryi.bean.dto.ShipingFeeTempDto;
import com.eryi.dao.CategoryDao;
import com.eryi.dao.ProductDao;
import com.eryi.dao.ShipingFeeTempDao;
import com.eryi.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    ProductDao productDao;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    ShipingFeeTempDao shipingFeeTempDao;

    @Override
    public int addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public int addCategory(Category category) {
        return categoryDao.addCategory(category);
    }

    @Override
    public int addShipingFeeTemp(ShipingFeeTemp shipingFeeTemp) {
        return shipingFeeTempDao.addShipingFeeTemp(shipingFeeTemp);
    }
}
