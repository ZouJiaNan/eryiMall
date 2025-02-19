package com.eryi.mapper;

import com.eryi.bean.bo.shop.ShipingFeeTemp;
import com.eryi.bean.po.ShipingFeeTempPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShipingFeeTempMapper {
    int addShipingFeeTemp(ShipingFeeTempPo shipingFeeTemp);
    ShipingFeeTemp findById(String id);
    List<ShipingFeeTemp> findAll();
}
