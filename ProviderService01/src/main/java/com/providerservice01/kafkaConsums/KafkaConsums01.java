package com.providerservice01.kafkaConsums;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsums01 {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsums01.class);

    @KafkaListener(topics = "test_topic")
    public void  listen(ConsumerRecord<?, ?> record, Acknowledgment ack){
        System.out.printf("2 topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());


    }

}
