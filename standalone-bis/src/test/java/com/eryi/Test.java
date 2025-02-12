package com.eryi;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;

public class Test {
    @org.junit.jupiter.api.Test
    public void testProducer() throws Exception {
        //创建消费者，创建的时候可以指定该消费者属于哪个消费者组
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        //指定name server的地址
        producer.setNamesrvAddr("192.168.31.10:9876");
        producer.setSendMsgTimeout(10000);
        producer.start();
        //发送一千条信息
        for (int i = 0; i < 1; i++) {
            try {
                //消息，topic为TopicTest，后面跟的一串是tag
                Message msg = new Message("TopicTest" /* Topic */,
                        "TagA" /* Tag */,
                        ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
                );
                //延时消息
                msg.setDelayTimeLevel(16);
                //同步发送
                SendResult sendResult = producer.send(msg);
                /**异步发送，通过自定义回调函数的方式来触发响应
                 producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                countDownLatch.countDown();
                System.out.printf("%-10d OK %s %n", index, sendResult.getMsgId());
                }
                @Override
                public void onException(Throwable e) {
                countDownLatch.countDown();
                System.out.printf("%-10d Exception %s %n", index, e);
                e.printStackTrace();
                }
                }**/
                System.out.printf("%s%n", sendResult);
            } catch (Exception e) {
                e.printStackTrace();
                //Thread.sleep(1000);
            }
        }
        producer.shutdown();
    }

    @org.junit.jupiter.api.Test
    public void testComsumer() throws Exception {
        // 创建消费者，指定消费者组
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("please_rename_unique_group_name");
        // 设置 NameServer 地址
        consumer.setNamesrvAddr("192.168.31.10:9876");
        // 订阅主题和标签（* 表示订阅所有标签）
        consumer.subscribe("TopicTest", "TagA");

        // 注册消息监听器
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt msg : msgs) {
                    // 打印消息内容
                    System.out.printf("Received message: %s%n", new String(msg.getBody()));
                }
                // 消费成功
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        // 启动消费者
        consumer.start();
        System.out.println("Consumer started. Waiting for messages...");

        // 为了测试方便，设置消费者运行一段时间后自动停止
        Thread.sleep(30000); // 等待 30 秒消费消息
        consumer.shutdown();
    }
}
