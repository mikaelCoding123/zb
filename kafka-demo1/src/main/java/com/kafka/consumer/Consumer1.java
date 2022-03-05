package com.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.apache.kafka.common.protocol.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class Consumer1 {

    @KafkaListener(topics = "test_topic")
     //定义此消费者接收topic为“test_topic”的消息
//    监听服务器上的kafka是否有相关的消息发过来
//    record变量代表消息本身，可以通过ConsumerRecord<?,?>类型的record变量来打印接收的消息的各种信息
    public void listen (ConsumerRecord<?, ?> record, Acknowledgment ack) throws Exception {
        long timestamp = record.timestamp();
//        int i=1/0;
        System.out.printf("topic1 = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());

        try {
            ack.acknowledge();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = "test2")
    public void  listen2(Message message){
    }
}
