package com.eryi.controller;

import com.eryi.bean.bo.customer.CarItem;
import com.eryi.bean.bo.pay.order.Order;
import com.eryi.bean.dto.CarItemDto;
import com.eryi.bean.dto.OrderDto;
import com.eryi.bean.dto.ResultBean;
import com.eryi.service.CustomerService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("BisOrderController")
@RequestMapping("/bis/order")
public class CustomerController extends BaseController{
    //Î´¸¶¿î¶©µ¥
    private String topic="order_topic_prepar";

    @Autowired
    CustomerService customerService;

    @Autowired
    RocketMQTemplate rocketMQTemplate;
    @RequestMapping("createOrder")
    public ResultBean createOrder(String userId,CarItemDto carItemDto) {
        CarItem carItem = new CarItem();
        carItem.setCarId(carItemDto.getCarId());
        carItem.getOnSale().setId(carItemDto.getOnSaleId());
        return success(customerService.createOrder(carItem));
    }

    @RequestMapping("payOrder")
    public ResultBean payOrder(Order order) {
        //Ö§¸¶¶©µ¥
        //¿Û¼õ¿â´æ
        return success(1);
    }

    @PostMapping
    public ResultBean addCarItem(String productId,String userId) {
        //Ìí¼Ó¹ºÎï³µ
        return success(customerService.addCarItem(productId,userId));
    }
}
