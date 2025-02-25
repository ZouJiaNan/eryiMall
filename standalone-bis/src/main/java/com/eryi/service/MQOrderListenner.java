package com.eryi.service;

import com.eryi.bean.bo.pay.order.Order;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(
        topic = "${my.topic.order}",
        consumerGroup = "${rocketmq.producer.group}",
        selectorExpression = "*", // 消费所有 Tag
        consumeThreadNumber = 4   // 消费线程数
)
public class MQOrderListenner implements RocketMQListener<Order> {
    @Autowired
    CustomerService  customerService;
    @Override
    public void onMessage(Order order) {
        //订单落库
        customerService.addOrder(order);
    }
}
