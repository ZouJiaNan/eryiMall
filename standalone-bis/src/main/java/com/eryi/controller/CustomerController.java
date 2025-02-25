package com.eryi.controller;

import com.eryi.bean.bo.common.User;
import com.eryi.bean.bo.customer.CarItem;
import com.eryi.bean.bo.pay.order.Order;
import com.eryi.bean.bo.pay.order.OrderItem;
import com.eryi.bean.bo.product.OnSale;
import com.eryi.bean.bo.product.Product;
import com.eryi.bean.dto.CarItemDto;
import com.eryi.bean.dto.OrderDto;
import com.eryi.bean.dto.ResultBean;
import com.eryi.service.CustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController("BisOrderController")
@RequestMapping("/bis/customer")
public class CustomerController extends BaseController{

    @Autowired
    CustomerService customerService;

    /**
     * 创建订单
     * @param orderDto
     *
     */
    @PostMapping("order")
    public ResultBean createOrder(@RequestBody OrderDto orderDto) {
        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setUser(new User(orderDto.getUserId()));
        orderDto.getOrderItems().forEach(orderItemDto -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setOnSale(new OnSale(orderItemDto.getOnSaleId()));
            orderItem.setCount(orderDto.getTotalCount());
            order.setOrderItems(new ArrayList<>());
            order.getOrderItems().add(orderItem);
        });
        return success(customerService.createOrder(order));
    }

    /**
     * 支付订单
     * @param order
     * @return
     */
    @PostMapping("payOrder")
    public ResultBean payOrder(Order order) {
        //支付订单
        //扣减库存
        return success(1);
    }

    @GetMapping("/onSale")
    public ResultBean getOnSaleList(String userId,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<OnSale> onSaleList = customerService.getOnSaleList(userId);
        PageInfo<OnSale> pageInfo = new PageInfo<>(onSaleList);
        //获取商品列表
        return success(pageInfo);
    }

    @PostMapping("/carItem")
    public ResultBean addCarItem(String onSaleId,String userId) {
        return success(customerService.addCarItem(userId,onSaleId));
    }

}
