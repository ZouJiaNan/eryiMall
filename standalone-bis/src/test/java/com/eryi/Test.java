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
        //���������ߣ�������ʱ�����ָ���������������ĸ���������
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        //ָ��name server�ĵ�ַ
        producer.setNamesrvAddr("192.168.31.10:9876");
        producer.setSendMsgTimeout(10000);
        producer.start();
        //����һǧ����Ϣ
        for (int i = 0; i < 1; i++) {
            try {
                //��Ϣ��topicΪTopicTest���������һ����tag
                Message msg = new Message("TopicTest" /* Topic */,
                        "TagA" /* Tag */,
                        ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
                );
                //��ʱ��Ϣ
                msg.setDelayTimeLevel(16);
                //ͬ������
                SendResult sendResult = producer.send(msg);
                /**�첽���ͣ�ͨ���Զ���ص������ķ�ʽ��������Ӧ
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
        // ���������ߣ�ָ����������
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("please_rename_unique_group_name");
        // ���� NameServer ��ַ
        consumer.setNamesrvAddr("192.168.31.10:9876");
        // ��������ͱ�ǩ��* ��ʾ�������б�ǩ��
        consumer.subscribe("TopicTest", "TagA");

        // ע����Ϣ������
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt msg : msgs) {
                    // ��ӡ��Ϣ����
                    System.out.printf("Received message: %s%n", new String(msg.getBody()));
                }
                // ���ѳɹ�
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        // ����������
        consumer.start();
        System.out.println("Consumer started. Waiting for messages...");

        // Ϊ�˲��Է��㣬��������������һ��ʱ����Զ�ֹͣ
        Thread.sleep(30000); // �ȴ� 30 ��������Ϣ
        consumer.shutdown();
    }
}
