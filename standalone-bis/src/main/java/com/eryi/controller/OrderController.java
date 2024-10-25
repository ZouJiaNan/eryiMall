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
    @RequestMapping("createOrder")
    public ResultBean createOrder(Order order) {
        //库存模块：锁定库存
        //优惠模块:优惠卷+优惠活动
        //积分模块：生成积分
        //物流模块：计算运费
        return success(order);
    }

    @RequestMapping("payOrder")
    public ResultBean payOrder(Order order) {
        //支付订单
        //扣减库存
        return success(1);
    }
}
