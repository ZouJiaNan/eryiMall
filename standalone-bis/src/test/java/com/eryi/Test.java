package com.eryi;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class Test {
    private String message="1111111111111111111111111111111111111111111111111111111\n" +
            "Installing C:\\IDEAWorkSpace\\pengesoft-costinfosite\\10����\\source\\PS_CostInfoSite\\publish\\bin\\PS_CostInfoSite.ps-cis-app.jar to D:\\MavenResp\\com\\pengesoft\\PS_CostInfoSite.ps-cis-app\\0.0.1-SNAPSHOT\\PS_CostInfoSite.ps-cis-app-0.0.1-SNAPSHOT.jar\n" +
            "Installing C:\\IDEAWorkSpace\\pengesoft-costinfosite\\10����\\source\\PS_CostInfoSite\\publish\\bin\\PS_CostInfoSite.ps-cis-app.jar to D:\\MavenResp\\com\\pengesoft\\PS_CostInfoSite.ps-cis-app\\0.0.1-SNAPSHOT\\PS_CostInfoSite.ps-cis-app-0.0.1-SNAPSHOT.jar\n" +
            "Installing C:\\IDEAWorkSpace\\pengesoft-costinfosite\\10����\\source\\PS_CostInfoSite\\publish\\bin\\PS_CostInfoSite.ps-cis-app.jar to D:\\MavenResp\\com\\pengesoft\\PS_CostInfoSite.ps-cis-app\\0.0.1-SNAPSHOT\\PS_CostInfoSite.ps-cis-app-0.0.1-SNAPSHOT.jar\n" +
            "Installing C:\\IDEAWorkSpace\\pengesoft-costinfosite\\10����\\source\\PS_CostInfoSite\\publish\\bin\\PS_CostInfoSite.ps-cis-app.jar to D:\\MavenResp\\com\\pengesoft\\PS_CostInfoSite.ps-cis-app\\0.0.1-SNAPSHOT\\PS_CostInfoSite.ps-cis-app-0.0.1-SNAPSHOT.jar\n";
    @org.junit.jupiter.api.Test
    public void testProducer() throws Exception {
        //���������ߣ�������ʱ�����ָ���������������ĸ���������
        DefaultMQProducer producer = new DefaultMQProducer("my-producer-group");
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
                        (message).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
                );
                //��ʱ��Ϣ
                msg.setDelayTimeLevel(16);
                //ͬ������
                SendResult sendResult = producer.send(msg);
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
        consumer.subscribe("order","*");

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

    //producerѹ��
    @org.junit.jupiter.api.Test
    public void test3() throws Exception {
        String namesrv = "192.168.31.10:9876";
        String topic = "stress_topic";
        int CONCURRENCY = 10; // ������
        int DURATION_SECONDS = 300; // ѹ��ʱ�����룩

        DefaultMQProducer producer = new DefaultMQProducer("stress_pool_producer_group");
        producer.setNamesrvAddr(namesrv);
        producer.start();

        // �̳߳����ã�����=���=10���������ޣ�
        ExecutorService executor = new ThreadPoolExecutor(
                CONCURRENCY,
                CONCURRENCY,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>()
        );

        AtomicLong successCount = new AtomicLong(0);
        AtomicLong failureCount = new AtomicLong(0);
        long startTime = System.currentTimeMillis();
        long endTime = startTime + DURATION_SECONDS * 1000;

        // �����ύ����ֱ���ﵽѹ��ʱ����
        while (System.currentTimeMillis() < endTime) {
            executor.submit(() -> {
                try {
                    Message msg = new Message(topic,
                            message.getBytes());
                    SendResult result = producer.send(msg);
                    if (result.getSendStatus() == SendStatus.SEND_OK) {
                        successCount.incrementAndGet();
                    }
                } catch (Exception e) {
                    failureCount.incrementAndGet();
                }
            });
        }

        // �ر��̳߳أ�ֹͣ����������
        executor.shutdown();
        // �ȴ�ʣ��������ɣ�����30�룩
        executor.awaitTermination(30, TimeUnit.SECONDS);
        producer.shutdown();

        // ��ӡ���
        printStats(startTime, System.currentTimeMillis(),
                successCount.get(), failureCount.get());

    }

    private static void printStats(long start, long end, long success, long fail) {
        System.out.println("\n======= ѹ���� =======");
        System.out.println("����Ϣ��: " + (success + fail));
        System.out.println("�ɹ�: " + success);
        System.out.println("ʧ��: " + fail);
        System.out.printf("��ʱ: %d ms\n", (end - start));
        System.out.printf("TPS: %.2f\n", (success * 1000.0 / (end - start)));
    }
}
