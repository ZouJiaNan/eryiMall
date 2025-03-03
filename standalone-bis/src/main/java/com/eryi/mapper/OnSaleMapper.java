package com.eryi.mapper;

import com.eryi.bean.bo.product.OnSale;
import com.eryi.bean.po.OnSalePo;
import com.eryi.dao.OnSaleDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OnSaleMapper {
    OnSale findById(String onSaleId);
    int addOnSale(OnSalePo onSalePo);
    int editOnSale(OnSalePo onSalePo);
    List<OnSale> getOnSaleList();
}
