package com.eryi.controller;

import com.eryi.domain.Order;
import com.eryi.dto.ResultBean;
import com.eryi.service.InventoryService;
import com.eryi.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.support.MessageBuilder;

@RestController("BisOrderController")
@RequestMapping("/bis/order")
public class OrderController extends BaseController{
    @Autowired
    InventoryService inventoryService;

    //未付款订单
    private String topic="order_topic_prepar";

    private ObjectMapper objectMapper=new ObjectMapper();

    @Autowired
    RocketMQTemplate rocketMQTemplate;
    @RequestMapping("createOrder")
    public ResultBean createOrder(Order order) {
        //库存模块：锁定库存
        order.getOrderItems().forEach(item->{
            inventoryService.lockStockByProductId(item);
        });
        //优惠模块:优惠卷+优惠活动
        //积分模块：生成积分
        //物流模块：计算运费
        //将创建好的order投入mq
        try {
            String json = objectMapper.writeValueAsString(order);
            rocketMQTemplate.send(topic,MessageBuilder.withPayload(json).build());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return success(order);
    }

    @RequestMapping("payOrder")
    public ResultBean payOrder(Order order) {
        //支付订单
        //扣减库存
        return success(1);
    }
}
