package com.eryi.service.impl;

import com.eryi.bean.bo.customer.Car;
import com.eryi.bean.bo.pay.order.Order;
import com.eryi.bean.bo.pay.order.OrderItem;
import com.eryi.bean.bo.product.OnSale;
import com.eryi.dao.CarDao;
import com.eryi.dao.OnSaleDao;
import com.eryi.dao.OrderDao;
import com.eryi.dao.ProductDao;
import com.eryi.service.CustomerService;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.MessageConst;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CarDao carDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    OnSaleDao onSaleDao;

    @Autowired
    OrderDao orderDao;

    @Value("${my.topic.order.delayed}")
    private String orderDelayedTopic;

    @Value("${my.topic.order}")
    private String orderTopic;

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    /**
     * ��ӹ��ﳵ
     * @param userId
     * @param onSaleId
     * @return
     */
    @Override
    @Transactional
    public int addCarItem(String userId,String onSaleId) {
        //��ȡ��Ѫģ��
        Car car = carDao.findByUserId(userId);
        //��ӹ��ﳵ
        return car.addCarItem(car.getId(),onSaleId);
    }

    /**
     * ��������
     * @param order
     * @return
     */
    @Override
    public int createOrder(Order order) {
        CompletableFuture<Object> future1 = new CompletableFuture<>();
        CompletableFuture<Void> future2 = new CompletableFuture<>();
        //������Сʱ��ʱ��Ϣ
        createOrderdelayed(future1,order);
        //�����߳�,������������д���߳��ϸ��ڴ�����ʱ��Ϣ���߳�ִ����ɺ���ִ��
        future1.thenCompose(delayResult-> createOrder(future2,order));
        return 1;
    }

    private CompletableFuture createOrder(CompletableFuture future,Order order){
        //д�����������
        Message<Order> message = MessageBuilder.withPayload(order)
                .build();
        rocketMQTemplate.asyncSend(orderTopic, message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("�첽���ͳɹ���" + sendResult.getMsgId());
                future.complete(null);
            }
            @Override
            public void onException(Throwable throwable) {
                System.out.println("�첽����ʧ�ܣ�" + throwable.getMessage());
                future.completeExceptionally(throwable);
            }
        },3000);
        return future;
    }

    private CompletableFuture createOrderdelayed(CompletableFuture future,Order order){
        //д��ʱ����
        Message<Order> delayedMessage = MessageBuilder.withPayload(order)
                .setHeader(MessageConst.PROPERTY_DELAY_TIME_LEVEL, "16")
                .build();
        rocketMQTemplate.asyncSend(orderDelayedTopic, delayedMessage, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("�첽���ͳɹ���" + sendResult.getMsgId());
                future.complete(null);
            }
            @Override
            public void onException(Throwable throwable) {
                System.out.println("�첽����ʧ�ܣ�" + throwable.getMessage());
                future.completeExceptionally(throwable);
            }
        },3000);
        return future;
    }

    /**
     * �����������
     * @param order
     * @return
     */
    public int addOrder(Order order) {
        orderDao.addOrder(order);
        order=orderDao.findOrderById(order.getId());
        for (OrderItem orderItem : order.getOrderItems()) {
            order.addOrderItem(orderItem);
        }
        return 1;
    }

    @Override
    public List<OnSale> getOnSaleList(String userId) {
        return onSaleDao.getOnSaleList(userId);
    }
}
