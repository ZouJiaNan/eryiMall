package com.eryi.mapper;

import com.eryi.bean.bo.shop.ShipingFeeTemp;
import com.eryi.bean.po.ShipingFeeTempPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShipingFeeTempMapper {
    int addShipingFeeTemp(ShipingFeeTempPo shipingFeeTemp);
    ShipingFeeTemp findById(String id);
}
