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
            "Installing C:\\IDEAWorkSpace\\pengesoft-costinfosite\\10编码\\source\\PS_CostInfoSite\\publish\\bin\\PS_CostInfoSite.ps-cis-app.jar to D:\\MavenResp\\com\\pengesoft\\PS_CostInfoSite.ps-cis-app\\0.0.1-SNAPSHOT\\PS_CostInfoSite.ps-cis-app-0.0.1-SNAPSHOT.jar\n" +
            "Installing C:\\IDEAWorkSpace\\pengesoft-costinfosite\\10编码\\source\\PS_CostInfoSite\\publish\\bin\\PS_CostInfoSite.ps-cis-app.jar to D:\\MavenResp\\com\\pengesoft\\PS_CostInfoSite.ps-cis-app\\0.0.1-SNAPSHOT\\PS_CostInfoSite.ps-cis-app-0.0.1-SNAPSHOT.jar\n" +
            "Installing C:\\IDEAWorkSpace\\pengesoft-costinfosite\\10编码\\source\\PS_CostInfoSite\\publish\\bin\\PS_CostInfoSite.ps-cis-app.jar to D:\\MavenResp\\com\\pengesoft\\PS_CostInfoSite.ps-cis-app\\0.0.1-SNAPSHOT\\PS_CostInfoSite.ps-cis-app-0.0.1-SNAPSHOT.jar\n" +
            "Installing C:\\IDEAWorkSpace\\pengesoft-costinfosite\\10编码\\source\\PS_CostInfoSite\\publish\\bin\\PS_CostInfoSite.ps-cis-app.jar to D:\\MavenResp\\com\\pengesoft\\PS_CostInfoSite.ps-cis-app\\0.0.1-SNAPSHOT\\PS_CostInfoSite.ps-cis-app-0.0.1-SNAPSHOT.jar\n";
    @org.junit.jupiter.api.Test
    public void testProducer() throws Exception {
        //创建消费者，创建的时候可以指定该消费者属于哪个消费者组
        DefaultMQProducer producer = new DefaultMQProducer("my-producer-group");
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
                        (message).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
                );
                //延时消息
                msg.setDelayTimeLevel(16);
                //同步发送
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
        // 创建消费者，指定消费者组
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("please_rename_unique_group_name");
        // 设置 NameServer 地址
        consumer.setNamesrvAddr("192.168.31.10:9876");
        // 订阅主题和标签（* 表示订阅所有标签）
        consumer.subscribe("order","*");

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

    //producer压测
    @org.junit.jupiter.api.Test
    public void test3() throws Exception {
        String namesrv = "192.168.31.10:9876";
        String topic = "stress_topic";
        int CONCURRENCY = 10; // 并发数
        int DURATION_SECONDS = 300; // 压测时长（秒）

        DefaultMQProducer producer = new DefaultMQProducer("stress_pool_producer_group");
        producer.setNamesrvAddr(namesrv);
        producer.start();

        // 线程池配置（核心=最大=10，队列无限）
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

        // 持续提交任务（直到达到压测时长）
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

        // 关闭线程池（停止接收新任务）
        executor.shutdown();
        // 等待剩余任务完成（最多等30秒）
        executor.awaitTermination(30, TimeUnit.SECONDS);
        producer.shutdown();

        // 打印结果
        printStats(startTime, System.currentTimeMillis(),
                successCount.get(), failureCount.get());

    }

    private static void printStats(long start, long end, long success, long fail) {
        System.out.println("\n======= 压测结果 =======");
        System.out.println("总消息数: " + (success + fail));
        System.out.println("成功: " + success);
        System.out.println("失败: " + fail);
        System.out.printf("耗时: %d ms\n", (end - start));
        System.out.printf("TPS: %.2f\n", (success * 1000.0 / (end - start)));
    }
}
