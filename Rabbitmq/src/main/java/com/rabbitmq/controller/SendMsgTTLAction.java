package com.rabbitmq.controller;

import com.rabbitmq.bean.User;
import com.rabbitmq.client.AMQP;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("ttl")
public class SendMsgTTLAction {
    @Resource
    private RabbitTemplate rt;


    //死信
    @GetMapping("sx")
    public void sx() throws IOException {
        User user = new User();
        for (int i = 0; i < 10; i++) {
            user.setPokid("sx==>"+i);
            rt.convertAndSend("exchange-hua", "test-two",user,new CorrelationData(UUID.randomUUID().toString()));
        }


    }



}
