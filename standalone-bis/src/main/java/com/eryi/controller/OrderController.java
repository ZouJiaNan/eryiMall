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
        //���ģ�飺�������
        //�Ż�ģ��:�Żݾ�+�Żݻ
        //����ģ�飺���ɻ���
        //����ģ�飺�����˷�
        return success(order);
    }

    @RequestMapping("payOrder")
    public ResultBean payOrder(Order order) {
        //֧������
        //�ۼ����
        return success(1);
    }
}
