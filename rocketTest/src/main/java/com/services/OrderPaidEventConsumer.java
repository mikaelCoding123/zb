package com.services;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RocketMQMessageListener(topic = "Test", consumerGroup = "Test112",consumeMode = ConsumeMode.CONCURRENTLY)
public class OrderPaidEventConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        System.out.println("------- 消息内容OrderPaidEventConsumer received:" + JSON.toJSONString(message));
        log.info("123");
    }
}