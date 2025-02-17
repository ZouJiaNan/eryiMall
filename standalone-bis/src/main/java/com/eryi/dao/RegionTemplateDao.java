package com.eryi.dao;

import com.eryi.bean.bo.shop.RegionTemplate;
import com.eryi.bean.dto.mapper.RegionTemplateMapper;
import com.eryi.bean.po.RegionTemplatePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RegionTemplateDao {
    @Autowired
    RegionTemplateMapper regionTemplateMapper;
    public int insertRegionTemplate(List<RegionTemplate> regionTemplateList){
        List<RegionTemplatePo> regionTemplatePoList =new ArrayList<>();
        regionTemplateList.forEach(regionTemplate -> {

        });
        return  regionTemplateMapper.insertRegionTemplate(regionTemplatePoList);
    }
}
