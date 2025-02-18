package com.eryi.bean.bo.customer;

import com.eryi.bean.bo.common.User;
import com.eryi.bean.bo.product.Product;
import com.eryi.bean.dto.CarItemDto;
import com.eryi.dao.CarDao;
import lombok.*;

import java.util.List;

/**
 * ¹ºÎï³µ
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {
    private CarDao carDao;
    private String id;
    private User user;
    private List<CarItem> items;

    public int addCarItem(String carId, String userId,String onSaleId)
    {
        CarItemDto carItemDto=new CarItemDto();
        carItemDto.setCarId(carId);
        carItemDto.setOnSaleId(onSaleId);
        return carDao.addCarItem(carItemDto);
    }
}
