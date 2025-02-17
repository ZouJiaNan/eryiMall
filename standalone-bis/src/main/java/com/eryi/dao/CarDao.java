package com.eryi.dao;

import com.eryi.bean.bo.customer.Car;
import com.eryi.bean.dto.CarItemDto;
import com.eryi.bean.dto.mapper.CarItemMapper;
import com.eryi.bean.dto.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class CarDao {
    @Autowired
    CarMapper carMapper;

    @Autowired
    CarItemMapper carItemMapper;

    /**
     * 构建满血模型
     * @param car
     * @return
     */
    private Car build(Car car){
        car.setCarDao(this);
        return car;
    }
    public Car findByUserId(String userId){
        Car car = carMapper.getCarByUserId(userId);
        return build(carMapper.getCarByUserId(userId));
    }

    public int addCarItem(CarItemDto carItemDto){
        return carItemMapper.addCarItem(carItemDto);
    }
}
