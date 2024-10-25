package com.eryi.controller;

import com.eryi.domain.Order;
import com.eryi.dto.ResultBean;
import com.eryi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("BisOrderController")
@RequestMapping("/bis/order")
public class OrderController extends BaseController{
    @Autowired
    ProductService productService;
    @RequestMapping("createOrder")
    public ResultBean createOrder(Order order) {
        //��������
        productService.getProductById("1");
        //�������
        return success(1);
    }

    @RequestMapping("payOrder")
    public ResultBean payOrder(Order order) {
        //֧������
        //�ۼ����
        return success(1);
    }
}
