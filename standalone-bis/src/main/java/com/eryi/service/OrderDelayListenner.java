package com.eryi.service;

import com.eryi.bean.bo.pay.order.Order;
import com.eryi.bean.bo.product.OnSale;
import com.eryi.dao.OnSaleDao;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(
        topic = "${my.topic.order.delayed}",
        consumerGroup = "${rocketmq.consumer.group.orderdelay}",
        selectorExpression = "*", // 消费所有 Tag
        consumeThreadNumber = 4   // 消费线程数
)
public class OrderDelayListenner implements RocketMQListener<Order> {
    @Autowired
    OnSaleDao onSaleDao;
    @Override
    public void onMessage(Order order) {
        System.out.println("延迟消息-"+order.toString());
        //1.检查订单状态
        //2.如果订单状态是未支付，则取消订单
        //3.释放库存
        OnSale onSale = onSaleDao.findById(order.getOrderItems().get(0).getOnSale().getId());
        onSaleDao.releaseStock(onSale,order.getOrderItems().get(0).getCount());
    }
}
