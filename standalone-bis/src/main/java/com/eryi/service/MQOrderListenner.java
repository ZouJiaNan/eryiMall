package com.eryi.service;

import com.eryi.bean.bo.pay.order.Order;
import org.apache.rocketmq.common.message.MessageConst;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(
        topic = "${my.topic.order}",
        consumerGroup = "${rocketmq.consumer.group.order}",
        selectorExpression = "*", // �������� Tag
        consumeThreadNumber = 4   // �����߳���
)
public class MQOrderListenner implements RocketMQListener<Order> {
    @Autowired
    CustomerService  customerService;
    @Override
    public void onMessage(Order order) {
        {
            //�������
            customerService.addOrder(order);
            System.out.println("�������-" + order.toString());
        }
    }
}
