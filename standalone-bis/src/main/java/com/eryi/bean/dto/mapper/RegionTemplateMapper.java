package com.eryi.bean.dto.mapper;

import com.eryi.bean.bo.shop.RegionTemplate;
import com.eryi.bean.po.RegionTemplatePo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegionTemplateMapper {
    int insertRegionTemplate(List<RegionTemplatePo> regionTemplateList);
}
