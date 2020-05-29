package com.paic.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerDemo {
    public static void produce() {
        Properties props = new Properties();
        //指定kafka的服务器的地址
        //只需要保证启动时设置的一个节点正常连接即可，后续变更或宕机不影响集群其它机器使用
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put("bootstrap.servers", "localhost:9092");
        //消息的确认机制
        props.put("acks", "all");
        //重试机制
        props.put("retries", 1);
        //批量发送的大小
        props.put("batch.size", 16384);
        //消息的延迟
        props.put("linger.ms", 1);
        //消息缓冲区的大小
        props.put("buffer.memory", 33554432);
        //定义key和value的序列化
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // props.put("partitioner.class","com.paic.kafka.MyPartitioner");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        long s = System.currentTimeMillis();
        for (long i = 0; i < 1000000L; i++) {
            //第一种分区策略，既没有指定数据key，也没有指定分区号，直接使用轮询的方式进行数据分区策略
            //ProducerRecord<String, String> producerRecord = new ProducerRecord<>("test", "这是第" + i + "条message");

            //第二种：指定数据key，通过key.hashCode来决定数据的分区  一定要注意，数据的key，需要进行变化
            //ProducerRecord<String, String> producerRecord = new ProducerRecord<>("test", "这是第" + i + "条message");

            //第三种：指定了数据key，也指定了分区号，直接将数据发送到对应的分区里面去
            //ProducerRecord<String, String> producerRecord = new ProducerRecord<>("test", 1,"mykey"+i,"这是第" + i + "条message");

            //自定义分区策略，不需要指定分区号，如果指定了分区号，还是会将数据发送到指定的分区里面去
            ProducerRecord<String, String> producerRecord = new ProducerRecord<>("test", "mykey" + i, "hello world message" + i);

            producer.send(producerRecord);
        }
        System.out.println("produce 100W cost(ms): " + (System.currentTimeMillis() - s));
        producer.close();

    }

}
