package com.services;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ExtRocketMQTemplateConfiguration;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RocketMQMessageListener(topic = "Nor1", consumerGroup = "Test3")
public class OrderPaidEventConsumer2 implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        System.out.print("------- 消息内容OrderPaidEventConsumer received:"+ JSON.toJSONString(message));
    }
}