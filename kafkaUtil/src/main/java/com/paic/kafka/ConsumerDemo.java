package com.paic.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLongArray;

public class ConsumerDemo {
    public static final int consumers = 4;
    private static AtomicLongArray timeRecords = new AtomicLongArray(consumers);

    public static void consume() {
        //连接集群
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        //消费组
        props.put("group.id", "test");

        //以下两行代码 ---消费者自动提交offset值
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(props);
        //发送数据 发送数据需要，订阅下要消费的topic。	test
        kafkaConsumer.subscribe(Arrays.asList("test"));
        long index = 0;
        while (true) {
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(10);// jdk queue offer插入、poll获取元素。 blockingqueue put插入原生， take获取元素
            for (ConsumerRecord<String, String> record : consumerRecords) {
                if (index == 0) {
                    long s = System.currentTimeMillis();
                    System.out.println("consume run time:" + s);
                    for (int i = 0; i < consumers; i++) {
                        timeRecords.compareAndSet(i, 0, s);
                    }
                }
                index++;
                if (record.key().equals("mykey999999")) {
                    if (timeRecords.get(0) != 0) {
                        System.out.println("consume 100W cost(ms):" + (System.currentTimeMillis() - timeRecords.get(0)));
                    }
                }
            }

        }
    }
}

