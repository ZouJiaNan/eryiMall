package com.eryi.dao;

import com.eryi.bean.bo.shop.RegionTemplate;
import com.eryi.bean.bo.shop.ShipingFeeTemp;
import com.eryi.mapper.RegionTemplateMapper;
import com.eryi.bean.po.RegionTemplatePo;
import com.eryi.bean.po.ShipingFeeTempPo;
import com.eryi.mapper.ShipingFeeTempMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ShipingFeeTempDao {
    @Autowired
    ShipingFeeTempMapper shipingFeeTempMapper;

    @Autowired
    RegionTemplateMapper regionTemplateMapper;

    private ShipingFeeTemp build(ShipingFeeTemp shipingFeeTemp){
        shipingFeeTemp.setShipingFeeTempDao(this);
        return shipingFeeTemp;
    }
    public int addShipingFeeTemp(ShipingFeeTemp shipingFeeTemp){
        ShipingFeeTempPo shipingFeeTempPo = new ShipingFeeTempPo();
        shipingFeeTempPo.setId(shipingFeeTemp.getId());
        shipingFeeTempPo.setName(shipingFeeTemp.getName());
        shipingFeeTempPo.setType(shipingFeeTemp.getType());
        shipingFeeTempPo.setShopId(shipingFeeTemp.getShop().getId());
        int i = shipingFeeTempMapper.addShipingFeeTemp(shipingFeeTempPo);
        return i;
    }

    public ShipingFeeTemp findById(String id){
        return build(shipingFeeTempMapper.findById(id));
    }



    public int addRegionTemplate(List<RegionTemplate> regionTemplateList){
        List<RegionTemplatePo> list=new ArrayList<>();
        regionTemplateList.forEach(regionTemplate -> {
            RegionTemplatePo regionTemplatePo=new RegionTemplatePo();
            regionTemplatePo.setShipingFeeTempId(regionTemplate.getShipingFeeTempId());
            regionTemplatePo.setAreaCode(regionTemplate.getAreaCode());
            regionTemplatePo.setAreaName(regionTemplate.getAreaName());
            regionTemplatePo.setFirstUnit(regionTemplate.getFirstUnit());
            regionTemplatePo.setFirstUnitPrice(regionTemplate.getFirstUnitPrice());
            regionTemplatePo.setFreeCondition(regionTemplate.getFreeCondition());
            regionTemplatePo.setNextUnitPrice(regionTemplate.getNextUnitPrice());
            regionTemplatePo.setNextUnit(regionTemplate.getNextUnit());
            list.add(regionTemplatePo);
        });
        return regionTemplateMapper.insertRegionTemplate(list);
    }
}
