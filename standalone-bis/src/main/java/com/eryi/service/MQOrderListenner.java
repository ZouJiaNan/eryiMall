package com.eryi.service;

import com.alibaba.fastjson.JSON;
import com.eryi.bean.bo.pay.order.Order;
import com.eryi.bean.bo.product.OnSale;
import com.eryi.dao.OnSaleDao;
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
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    OnSaleDao onSaleDao;

    @Override
    public void onMessage(Object o) {

    }

    @Override
    @Transactional
    public void prepareStart(DefaultMQPushConsumer defaultMQPushConsumer) {
        defaultMQPushConsumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            for (MessageExt msg : msgs) {
                try {
                    Order order = JSON.parseObject(msg.getBody(), Order.class);
                    //新增订单
                    if(order.getStatus()==1){
                        addOrder(order);
                    }
                    //支付订单
                    if(order.getStatus()==2){
                        payOrder(order);
                    }
                    // 手动ACK（成功）
                    context.setAckIndex(msgs.indexOf(msg));
                } catch (Exception e) {
                    log.info("处理订单失败:" + e.getMessage());
                    // 消息重试（失败）
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
    }

    private void addOrder(Order order){
        //订单落库
        customerService.addOrder(order);
        log.info("新增订单:" , order);
    }

    private void payOrder(Order order){
        customerService.updateOrder(order);
        log.info("支付订单:" , order);
    }
}
