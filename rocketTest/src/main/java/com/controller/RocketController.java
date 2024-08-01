package com.controller;

import cn.hutool.core.lang.Snowflake;
import com.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@RestController
@Slf4j
public class RocketController {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    //延时消息
    @RequestMapping("TestAdd")
    public void TestAdd() {
        long l = System.currentTimeMillis();        //Test消息的主题 要和消费者的主题保持一致
        SendResult test = rocketMQTemplate.syncSend("Test", MessageBuilder.withPayload("user").build(), 2000, 3);//delayLevel 延时时间18个等级 1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
        long l1 = System.currentTimeMillis();
        System.out.println("=======上述代码执行时间为:=====" + (l1 - l)+"Millis");
        System.out.println("发送成功");
    }

    //一般消息
    @RequestMapping("Nor")
    public void pt() {
        User user = new User();
        user.setPokid(new Snowflake().nextIdStr());
        rocketMQTemplate.syncSend("Nor", user, 2000);
    }

    //批量发送消息
    @RequestMapping("batch")
    public String batch() {
        long l = System.currentTimeMillis();

        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            Message message = new Message();
            user.setPokid(""+i);
            message.setBody(user.toString().getBytes(StandardCharsets.UTF_8));
            users.add(user);
        }

        rocketMQTemplate.syncSend("batch", users, 2000);
        log.info("上述代码执行时间===》{}", (System.currentTimeMillis() - l));
        return "12";


    }
    @PostMapping("sequentialMessage")
    public void sequentialMessage(){
        MessageQueue messageQueue = new MessageQueue();
        messageQueue.setQueueId(123);
        messageQueue.setTopic("sequentialMessage");
        rocketMQTemplate.syncSend("sequential", messageQueue);

    }

    /**
     * 接受方报错
     */
    @PostMapping("MessageException")
    public void sequentialMessage1(){
        MessageQueue messageQueue = new MessageQueue();
        messageQueue.setQueueId(123);
        messageQueue.setTopic("sequentialMessage");
        SendResult sequential = rocketMQTemplate.syncSend("sequential", messageQueue);
        System.out.println("sequential==》"+sequential.toString());

    }
    /**
     * 用事务
     */
    @PostMapping("transaction01")
    public void transaction01(){
        Message message = new Message();
        message.setTopic("transaction01");
        MessageBuilder<String> builder = MessageBuilder.withPayload("");

//        rocketMQTemplate.sendMessageInTransaction("producer", "transaction01", message, "01");
    }

    public static void main(String[] args) {
        User user = new User();
        user.setPokid(""+1);
        System.out.println(user);
    }
}
