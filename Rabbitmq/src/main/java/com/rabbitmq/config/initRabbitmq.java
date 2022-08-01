package com.rabbitmq.config;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.messaging.converter.JsonbMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import sun.java2d.pipe.SpanIterator;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

@Component
@Slf4j
public class initRabbitmq {
    @Resource
    private RabbitTemplate rt;

    /**
     * 发送方到rabbitmq时发生错误会触发，rabbitmq返回的错误信息returnedMsg
     */
    @PostConstruct
    public void initCallback() {
        rt.setMessageConverter(new Jackson2JsonMessageConverter());

        //消息没有投递到指定的queue，就触发这个回调
        rt.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {
                String s1 = null;
                try {
                    s1 = new String(returnedMessage.getMessage().getBody(), "utf-8");
                    //s1为{"pokid":"123","username":"明ke12k龚龖","password":null}
                    log.info("没有投递到指定的queue"+s1);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        });
        // 消息发送到 Broker 后触发回调，确认消息是否到达 Broker 服务器，也就是只确认是否正确到达 Exchange 中
        //correlationData 消息唯一id
        //arrival   消息是否成功收到
        //cause    失败原因
        rt.setConfirmCallback((correlationData, arrival, cause) -> {
            assert correlationData != null;
            if (arrival) {
                log.info("消息已发送到交换机，MessageId：{}", correlationData.getId());
            } else {
                log.info("消息发送失败，MessageId：{}，失败原因：{}", correlationData.getId(), cause);
            }
        });
    }


}
