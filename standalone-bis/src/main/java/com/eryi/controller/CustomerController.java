package com.eryi.controller;

import com.eryi.bean.bo.customer.CarItem;
import com.eryi.bean.bo.pay.order.Order;
import com.eryi.bean.dto.CarItemDto;
import com.eryi.bean.dto.ResultBean;
import com.eryi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("BisOrderController")
@RequestMapping("/bis/order")
public class CustomerController extends BaseController{

    @Autowired
    CustomerService customerService;
    @RequestMapping("createOrder")
    public ResultBean createOrder(String userId,CarItemDto carItemDto) {
        CarItem carItem = new CarItem();
        carItem.setCarId(carItemDto.getCarId());
        carItem.getOnSale().setId(carItemDto.getOnSaleId());
        return success(customerService.createOrder(carItem));
    }

    @RequestMapping("payOrder")
    public ResultBean payOrder(Order order) {
        //֧������
        //�ۼ����
        return success(1);
    }

    @PostMapping
    public ResultBean addCarItem(String productId,String userId) {
        //��ӹ��ﳵ
        return success(customerService.addCarItem(productId,userId));
    }
}
