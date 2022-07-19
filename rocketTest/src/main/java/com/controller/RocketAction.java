package com.controller;

import com.RocketTestApplication;
import com.bean.User;
import com.response.ServiceResult;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("test")
public class RocketAction {

    @Autowired
    private RocketMQTemplate mq;

//    rocketmq 事务消息示例
    @PostMapping("first")
    public ServiceResult getFirst(){
        User user = new User();
        user.setPokid("23");
        user.setUsername("ming");
        Message<User> build = MessageBuilder.withPayload(user).setHeader(RocketMQHeaders.TRANSACTION_ID, user).build();
        ServiceResult serviceResult = new ServiceResult();
        TransactionSendResult transactionSendResult = mq.sendMessageInTransaction("12Group", "topic_first1", build, "131");
        serviceResult.setResultCode("000000");
        return  serviceResult;
    }

}
