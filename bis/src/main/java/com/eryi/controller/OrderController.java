package com.eryi.controller;

import com.eryi.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("BisOrderController")
@RequestMapping("/bis/order")
public class OrderController {
//    @Autowired
//    ProductController productController;
//    @RequestMapping("createOrder")
//    public int createOrder(Order order) {
//        //´´½¨¶©µ¥
//        productController.getProductById(order.getId());
//        //Ëø¶¨¿â´æ
//        return 1;
//    }
//
//    @RequestMapping("payOrder")
//    public int payOrder(Order order) {
//        //Ö§¸¶¶©µ¥
//        //¿Û¼õ¿â´æ
//        return 1;
//    }
}
