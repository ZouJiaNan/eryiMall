package com.eryi.service.impl;

import com.eryi.bean.bo.Order;
import com.eryi.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(topic = "order_topic_formal", consumerGroup = "consumer-group", messageModel = MessageModel.CLUSTERING)
public class RocketMQConsumer implements RocketMQListener<String> {
    @Autowired
    OrderService orderService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onMessage(String s) {
        try {
            orderService.addOrder(objectMapper.readValue(s, Order.class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

