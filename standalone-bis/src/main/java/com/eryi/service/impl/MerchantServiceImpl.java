package com.eryi.service.impl;

import com.eryi.bean.bo.product.Category;
import com.eryi.bean.bo.product.OnSale;
import com.eryi.bean.bo.product.Product;
import com.eryi.bean.bo.shop.RegionTemplate;
import com.eryi.bean.bo.shop.ShipingFeeTemp;
import com.eryi.bean.dto.ProductDto;
import com.eryi.bean.dto.ResultBean;
import com.eryi.bean.dto.ShipingFeeTempDto;
import com.eryi.dao.*;
import com.eryi.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Autowired
    OnSaleDao onSaleDao;

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
        List<RegionTemplate> regionTemplateList = shipingFeeTemp.getRegionTemplateList();
        shipingFeeTemp = shipingFeeTempDao.findById(shipingFeeTemp.getId());
        //创建地区模板
        shipingFeeTemp.addRegionTemplate(regionTemplateList);
        return i;
    }

    @Override
    public int editOnSale(OnSale onSale) {
        return onSaleDao.editOnSale(onSale);
    }

    @Override
    public int addOnSale(OnSale onSale) {
        return onSaleDao.addOnSale(onSale);
    }
}
