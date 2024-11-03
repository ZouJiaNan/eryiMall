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

    //δ�����
    private String topic="order_topic_prepar";

    private ObjectMapper objectMapper=new ObjectMapper();

    @Autowired
    RocketMQTemplate rocketMQTemplate;
    @RequestMapping("createOrder")
    public ResultBean createOrder(Order order) {
        //���ģ�飺�������
        order.getOrderItems().forEach(item->{
            inventoryService.lockStockByProductId(item);
        });
        //�Ż�ģ��:�Żݾ�+�Żݻ
        //����ģ�飺���ɻ���
        //����ģ�飺�����˷�
        //�������õ�orderͶ��mq
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
        //֧������
        //�ۼ����
        return success(1);
    }
}
