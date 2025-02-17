package com.eryi.service.impl;

import com.eryi.bean.bo.product.Category;
import com.eryi.bean.bo.product.Product;
import com.eryi.bean.bo.shop.ShipingFeeTemp;
import com.eryi.bean.dto.ProductDto;
import com.eryi.bean.dto.ResultBean;
import com.eryi.bean.dto.ShipingFeeTempDto;
import com.eryi.dao.CategoryDao;
import com.eryi.dao.ProductDao;
import com.eryi.dao.RegionTemplateDao;
import com.eryi.dao.ShipingFeeTempDao;
import com.eryi.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    ProductDao productDao;

    @Autowired
    RegionTemplateDao regionTemplateDao;

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

    @Transactional
    @Override
    public int addShipingFeeTemp(ShipingFeeTemp shipingFeeTemp) {
        //创建运费模板
        int i = shipingFeeTempDao.addShipingFeeTemp(shipingFeeTemp);
        shipingFeeTemp = shipingFeeTempDao.findById(shipingFeeTemp.getId());
        //创建地区模板
        shipingFeeTemp.addRegionTemplate(shipingFeeTemp.getRegionTemplateList());
        return i;
    }
}
