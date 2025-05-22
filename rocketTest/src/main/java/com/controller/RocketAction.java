package com.controller;

import cn.hutool.core.lang.UUID;
import com.bean.User;
import com.enumcode.CodeEnum;
import com.common.ServiceResult;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("test")
public class RocketAction {

    @Resource
    private RocketMQTemplate mq;

    //    rocketmq 事务消息示例
    @PostMapping("first")
    public ServiceResult getFirst() {
        User user = new User();
        user.setPokid("23");
        user.setUsername("ming");
        CodeEnum.SUCCESS.setCode("yus");

        ServiceResult success = ServiceResult.success(CodeEnum.SUCCESS, user);
        Message<User> build = MessageBuilder.withPayload(user).setHeader(UUID.fastUUID().toString(), user).build();
        TransactionSendResult transactionSendResult = mq.sendMessageInTransaction("12Group", "topic_first1", build, success);
        if (LocalTransactionState.COMMIT_MESSAGE.equals(transactionSendResult.getLocalTransactionState())) {
            return null;
        }
        if (LocalTransactionState.ROLLBACK_MESSAGE.equals(transactionSendResult.getLocalTransactionState())) {
            return null;
        }
        if (LocalTransactionState.UNKNOW.equals(transactionSendResult.getLocalTransactionState())) {
            return null;
        }

        return ServiceResult.defaultSuccess();
    }

    //顺序消费消息
    @RequestMapping(value = "",method = RequestMethod.GET)
    public ServiceResult SequentiaMsg(){

        return null;
    }

}
