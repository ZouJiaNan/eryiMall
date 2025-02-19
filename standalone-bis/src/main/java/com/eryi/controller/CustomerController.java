package com.eryi.controller;

import com.eryi.bean.bo.customer.CarItem;
import com.eryi.bean.bo.pay.order.Order;
import com.eryi.bean.bo.product.OnSale;
import com.eryi.bean.bo.product.Product;
import com.eryi.bean.dto.CarItemDto;
import com.eryi.bean.dto.ResultBean;
import com.eryi.service.CustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("BisOrderController")
@RequestMapping("/bis/customer")
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
