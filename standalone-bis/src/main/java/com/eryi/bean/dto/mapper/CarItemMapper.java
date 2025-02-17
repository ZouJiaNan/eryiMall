package com.eryi.bean.dto.mapper;

import com.eryi.bean.bo.customer.CarItem;
import com.eryi.bean.dto.CarItemDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarItemMapper {
    int addCarItem(CarItemDto carItemDto);
}
