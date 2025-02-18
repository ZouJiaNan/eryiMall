package com.eryi.mapper;

import com.eryi.bean.po.OnSalePo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OnSaleMapper {
    int addOnSale(OnSalePo onSalePo);
    int editOnSale(OnSalePo onSalePo);
}
