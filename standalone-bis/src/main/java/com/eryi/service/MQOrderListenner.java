package com.eryi.service;

import com.alibaba.fastjson.JSON;
import com.eryi.bean.bo.pay.order.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(
        topic = "${my.topic.order}",
        consumerGroup = "${rocketmq.consumer.group.order}",
        selectorExpression = "*", // 消费所有 Tag
        consumeThreadNumber = 4   // 消费线程数
)
@Slf4j
public class MQOrderListenner implements RocketMQListener,RocketMQPushConsumerLifecycleListener {
    @Autowired
    CustomerService customerService;

    @Override
    public void onMessage(Object o) {

    }

    @Override
    public void prepareStart(DefaultMQPushConsumer defaultMQPushConsumer) {
        defaultMQPushConsumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            for (MessageExt msg : msgs) {
                try {
                    //订单落库
                    Order order = JSON.parseObject(msg.getBody(), Order.class);
                    customerService.addOrder(order);
                    log.info("订单落库成功:" + order.toString());
                    // 手动ACK（成功）
                    context.setAckIndex(msgs.indexOf(msg));
                } catch (Exception e) {
                    log.info("订单落库失败:" + e.getMessage());
                    // 消息重试（失败）
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
    }
}
