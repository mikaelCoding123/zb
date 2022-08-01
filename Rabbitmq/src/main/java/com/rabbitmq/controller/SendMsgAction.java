package com.rabbitmq.controller;

import com.rabbitmq.bean.User;
import com.response.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("mq")
@Slf4j
public class SendMsgAction {

    @Resource
    private RabbitTemplate rt;
    //简单的一对一发送   exchange-hua  direct
    @RequestMapping(value = "sendMsg-one",method = RequestMethod.POST)
    public ServiceResult sendoneMsg(){
        User user = new User();
        user.setPokid("123");
        user.setUsername("明ke12");
        rt.convertAndSend("exchange-hua","test-one",user);
        return null;
    }
    //简单的一对一发送   exchange-hua  direct   rabbitmq返回
    @RequestMapping(value = "sendMsg-one-ack",method = RequestMethod.POST)
    public ServiceResult sendoneMsgACK(){
        User user = new User();
        user.setPokid("123");
        user.setUsername("明ke12k龚龖");
        rt.convertAndSend("exchange-hua","test-one",user,new CorrelationData("12"));
        return null;
    }


    //简单的一对一发送   exchange-hua  direct   rabbitmq返回
    @RequestMapping(value = "sendMsg-one-ack_consumer",method = RequestMethod.POST)
    public ServiceResult sendoneMsgACK_consumer(){
        User user = new User();
        user.setPokid("123");
        user.setUsername("明ke12k龚龖");
        user.setPassword("consumer");
        rt.convertAndSend("exchange-hua","test-two",user,new CorrelationData("12"));
        return null;
    }




}
