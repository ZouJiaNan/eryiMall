//package com.eryi.service;
//
//import com.eryi.bean.bo.pay.order.Order;
//import com.eryi.bean.bo.product.OnSale;
//import com.eryi.dao.OnSaleDao;
//import com.eryi.dao.OrderDao;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@RocketMQMessageListener(
//        topic = "${my.topic.order.delayed}",
//        consumerGroup = "${rocketmq.consumer.group.orderdelay}",
//        selectorExpression = "*", // �������� Tag
//        consumeThreadNumber = 4   // �����߳���
//)
//@Slf4j
//public class OrderDelayListenner implements RocketMQListener<Order> {
//    @Autowired
//    OnSaleDao onSaleDao;
//
//    @Autowired
//    OrderDao orderDao;
//    @Override
//    @Transactional
//    public void onMessage(Order order) {
//        if(order==null){
//            return;
//        }
//        log.info("�ӳ���Ϣ-"+order.toString());
//        Order orderById = orderDao.findOrderById(order.getId());
//        if(orderById!=null && orderById.getStatus()==1){
//            //���¶���״̬Ϊ����
//            order.setStatus(7);
//            orderDao.updateOrder(order);
//            //�ͷſ��
//            String skuCode = order.getOrderItems().get(0).getProduct().getSkus().get(0).getSkuCode();
//            String productId = order.getOrderItems().get(0).getProduct().getId();
//            OnSale onSale = onSaleDao.findBySkuCodeAndProductId(productId,skuCode);
//            onSaleDao.releaseStock(onSale,order.getOrderItems().get(0).getCount());
//        }
//    }
//}
