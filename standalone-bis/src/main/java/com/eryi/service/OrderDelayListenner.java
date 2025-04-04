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
//        selectorExpression = "*", // 消费所有 Tag
//        consumeThreadNumber = 4   // 消费线程数
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
//        log.info("延迟消息-"+order.toString());
//        Order orderById = orderDao.findOrderById(order.getId());
//        if(orderById!=null && orderById.getStatus()==1){
//            //更新订单状态为超期
//            order.setStatus(7);
//            orderDao.updateOrder(order);
//            //释放库存
//            String skuCode = order.getOrderItems().get(0).getProduct().getSkus().get(0).getSkuCode();
//            String productId = order.getOrderItems().get(0).getProduct().getId();
//            OnSale onSale = onSaleDao.findBySkuCodeAndProductId(productId,skuCode);
//            onSaleDao.releaseStock(onSale,order.getOrderItems().get(0).getCount());
//        }
//    }
//}
