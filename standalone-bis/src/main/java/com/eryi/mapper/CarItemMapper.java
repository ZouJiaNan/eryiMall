package com.eryi.mapper;

import com.eryi.bean.bo.customer.CarItem;
import com.eryi.bean.dto.CarItemDto;
import com.eryi.bean.po.CarItemPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarItemMapper {
    int addCarItem(CarItemPo carItemPo);
}
