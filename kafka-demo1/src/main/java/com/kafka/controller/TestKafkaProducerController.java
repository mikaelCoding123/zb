package com.kafka.controller;

import com.bean.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.producer.ProducerRecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.lang.model.element.VariableElement;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("kafka")
public class TestKafkaProducerController {
    private static final Logger logger = LoggerFactory.getLogger(TestKafkaProducerController.class);
    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(12, 12, 100, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100));

    @Resource
//    定义一个kafka模板
    private KafkaTemplate<String, String> kafkaTemplate; //这里会报错，但不影响

    //当在浏览器上输入http://localhost:8080/kafka/send?msg=abc，就会发送abc到服务器上去让消费者接收，msg对应下面的String msg
    @RequestMapping("send")
    public String send(String msg) {
        User user = new User();
        user.setPokid("1");
        user.setUsername("61616@qq.com");
        user.setPassword("fkshfkjhksjhkfhksjhfuekjhd");
        Gson gson = new Gson();
        ObjectMapper objectMapper = new ObjectMapper();
        String s = gson.toJson(user);
        logger.info("1231312313213==>{}");
        kafkaTemplate.send("test_topic", s);
        kafkaTemplate.send("test_topic2", s);
        this.sender(s);


        return "success";
    }

    public void sender(String s) {


        ListenableFuture<SendResult<String, String>> test_topic = kafkaTemplate.send("test_topic", "1", s);//使用kafka模板发送信息
        test_topic.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("onFailure=====>");
                ex.printStackTrace();

            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                ProducerRecord<String, String> producerRecord = result.getProducerRecord();
                logger.info("onSuccess==》》{}", producerRecord.toString());
            }
        });

    }


}