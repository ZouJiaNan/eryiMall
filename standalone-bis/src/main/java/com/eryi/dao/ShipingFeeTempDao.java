package com.eryi.dao;

import com.eryi.bean.bo.shop.ShipingFeeTemp;
import com.eryi.bean.dto.ShipingFeeTempDto;
import com.eryi.bean.po.ShipingFeeTempPo;
import com.eryi.mapper.ShipingFeeTempMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShipingFeeTempDao {
    @Autowired
    ShipingFeeTempMapper shipingFeeTempMapper;
    public int addShipingFeeTemp(ShipingFeeTemp shipingFeeTemp){
        ShipingFeeTempPo shipingFeeTempPo = new ShipingFeeTempPo();
        shipingFeeTempPo.setId(shipingFeeTemp.getId());
        shipingFeeTempPo.setName(shipingFeeTemp.getName());
        return shipingFeeTempMapper.addShipingFeeTemp(shipingFeeTempPo);
    }
}
