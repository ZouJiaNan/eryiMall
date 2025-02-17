package com.eryi.bean.dto.mapper;

import com.eryi.bean.bo.customer.Car;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarMapper {
    Car getCarByUserId(String userId);
}
