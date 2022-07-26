package com.rabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class initRabbitmq {
    @Autowired
    private RabbitTemplate rt;

    @PostConstruct
    public void init(){
        rt.setReturnsCallback((returnedMsg)->{
            System.out.println("消息主体 message : " + returnedMsg.getMessage());
            System.out.println("消息主体 message : " + returnedMsg.getReplyCode());
            System.out.println("描述：" + returnedMsg.getReplyText());
            System.out.println("消息使用的交换器 exchange : " + returnedMsg.getExchange());
            System.out.println("消息使用的路由键 routing : " + returnedMsg.getRoutingKey());


        });
        // 消息发送到 Broker 后触发回调，确认消息是否到达 Broker 服务器，也就是只确认是否正确到达 Exchange 中
        rt.setConfirmCallback((correlationData, arrival, cause)->{
            assert correlationData != null;
            if (arrival) {
                log.info("消息已发送到交换机，MessageId：{}", correlationData.getId());
            } else {
                log.info("消息发送失败，MessageId：{}，失败原因：{}", correlationData.getId(), cause);
            }
        });
    }


}
