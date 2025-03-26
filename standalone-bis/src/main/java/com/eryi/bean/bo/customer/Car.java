package com.eryi.bean.bo.customer;

import com.eryi.bean.bo.common.User;
import com.eryi.bean.bo.product.Product;
import com.eryi.bean.dto.CarItemDto;
import com.eryi.bean.po.CarItemPo;
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

    public int addCarItem(String carId, String productId)
    {
        CarItemPo carItemPo=new CarItemPo();
        carItemPo.setCarId(carId);
        carItemPo.setProductId(productId);
        return carDao.addCarItem(carItemPo);
    }
}
