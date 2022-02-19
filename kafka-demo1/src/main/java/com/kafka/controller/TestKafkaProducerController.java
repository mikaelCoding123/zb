package com.kafka.controller;

import com.bean.User;
import com.google.gson.Gson;
import org.apache.kafka.clients.producer.ProducerRecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController     //定义这是一个控制器，可以通过浏览器访问
@RequestMapping("kafka")
public class TestKafkaProducerController {
    private static final Logger logger = LoggerFactory.getLogger(TestKafkaProducerController.class);

    @Resource
//    定义一个kafka模板
    private KafkaTemplate<String, String> kafkaTemplate; //这里会报错，但不影响

    //当在浏览器上输入http://localhost:8080/kafka/send?msg=abc，就会发送abc到服务器上去让消费者接收，msg对应下面的String msg
    @RequestMapping("send")
    public String send(String msg){
        User user = new User();
        user.setPokid("1");
        user.setUsername("61616@qq.com");
        user.setPassword("fkshfkjhksjhkfhksjhfuekjhd");
        Gson gson = new Gson();
        String s = gson.toJson(user);
        ListenableFuture<SendResult<String, String>> test_topic = kafkaTemplate.send("test_topic", s);//使用kafka模板发送信息
        test_topic.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                ex.printStackTrace();
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                ProducerRecord<String, String> producerRecord = result.getProducerRecord();
                logger.info("onSuccess==》》{}",producerRecord.toString());
            }
        });

        return "success";
    }



}