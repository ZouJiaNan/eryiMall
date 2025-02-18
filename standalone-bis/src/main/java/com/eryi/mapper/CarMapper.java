package com.eryi.mapper;

import com.eryi.bean.bo.customer.Car;
import com.eryi.bean.po.CarPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarMapper {
    Car getCarByUserId(String userId);
    int addCar(CarPo carPo);
}
