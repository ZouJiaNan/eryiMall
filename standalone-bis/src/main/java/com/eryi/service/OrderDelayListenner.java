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
        selectorExpression = "*", // �������� Tag
        consumeThreadNumber = 4   // �����߳���
)
public class OrderDelayListenner implements RocketMQListener<Order> {
    @Autowired
    OnSaleDao onSaleDao;
    @Override
    public void onMessage(Order order) {
        System.out.println("�ӳ���Ϣ-"+order.toString());
        //1.��鶩��״̬
        //2.�������״̬��δ֧������ȡ������
        //3.�ͷſ��
        OnSale onSale = onSaleDao.findById(order.getOrderItems().get(0).getOnSale().getId());
        onSaleDao.releaseStock(onSale,order.getOrderItems().get(0).getCount());
    }
}
