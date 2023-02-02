package com.services;


import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;

import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(topic = "topic_first1",consumerGroup = "12Group")
public class Js01 implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        log.info("Js01====>"+s);
    }
}
