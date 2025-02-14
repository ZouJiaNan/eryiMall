package com.eryi.service;

import com.eryi.bean.bo.product.Category;
import com.eryi.bean.bo.product.Product;
import com.eryi.bean.bo.shop.ShipingFeeTemp;
import com.eryi.bean.dto.ShipingFeeTempDto;

public interface MerchantService {
    int addProduct(Product product);
    int addCategory(Category category);
    int addShipingFeeTemp(ShipingFeeTemp shipingFeeTemp);
}
