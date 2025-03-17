package com.eryi.service.impl;

import com.eryi.bean.bo.product.*;
import com.eryi.bean.bo.shop.RegionTemplate;
import com.eryi.bean.bo.shop.ShipingFeeTemp;
import com.eryi.bean.dto.ProductDto;
import com.eryi.bean.dto.ResultBean;
import com.eryi.bean.dto.ShipingFeeTempDto;
import com.eryi.bean.po.ProductPo;
import com.eryi.dao.*;
import com.eryi.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        //�����˷�ģ��
        int i = shipingFeeTempDao.addShipingFeeTemp(shipingFeeTemp);
        List<RegionTemplate> regionTemplateList = shipingFeeTemp.getRegionTemplateList();
        shipingFeeTemp = shipingFeeTempDao.findById(shipingFeeTemp.getId());
        //��������ģ��
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

    @Override
    public List<ShipingFeeTemp> getShipingFeeTempList(String userId) {
        return shipingFeeTempDao.findAll(userId);
    }

    @Override
    public List<Product> getProductList(String userId) {
        return productDao.findAll();
    }

    @Override
    public int addSPU(String productId,String spuJson) {
        return productDao.addSPU(productId,spuJson);
    }

    @Override
    public int addSKU(String productId,String skuJson) {
        return productDao.addSKU(productId,skuJson);
    }
}
