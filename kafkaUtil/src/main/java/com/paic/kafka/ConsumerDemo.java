package com.paic.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class ConsumerDemo {
    public static void consume() {
        //连接集群
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
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
        long s = 0;
        while (true) {
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(10);// jdk queue offer插入、poll获取元素。 blockingqueue put插入原生， take获取元素
            for (ConsumerRecord<String, String> record : consumerRecords) {
                if (index == 0) {
                    s = System.currentTimeMillis();
                }
                index++;
//                System.out.println("get：" + record.value());
                if (index > 999999) {
                    System.out.println("consume 100W cost(ms): " + (System.currentTimeMillis() - s));
                }
            }

        }
    }
}

