package com.eryi.dao;

import com.eryi.bean.bo.common.User;
import com.eryi.bean.bo.customer.Car;
import com.eryi.bean.dto.CarItemDto;
import com.eryi.bean.po.CarItemPo;
import com.eryi.bean.po.CarPo;
import com.eryi.mapper.CarItemMapper;
import com.eryi.mapper.CarMapper;
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
        if(car==null){
            CarPo carPo = new CarPo(UUID.randomUUID().toString(),userId);
            carMapper.addCar(carPo);
            car = new Car();
            car.setUser(new User(userId));
            car.setId(carPo.getId());
            car.getUser().setId(userId);
        }
        return build(carMapper.getCarByUserId(userId));
    }

    public int addCarItem(CarItemPo carItemPo){
        return carItemMapper.addCarItem(carItemPo);
    }
}
