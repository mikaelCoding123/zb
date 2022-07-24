package com.rabbitmq;

import com.rabbitmq.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class RabbitmqApplicationTests {
    @Autowired
    AmqpAdmin amqpAdmin;
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {

        DirectExchange directExchange = new DirectExchange("exchange-test", true, false);
        amqpAdmin.declareExchange(directExchange);
        log.info("exchange创建成功！！！");
    }

    @Test
    public void createQueue(){
        Queue queue = new Queue("test-one");
        amqpAdmin.declareQueue(queue);
        log.info("queue创建成功！！");
    }
    @Test
    public void sendMsg(){
        User user = new User();
        user.setPokid("12");
        user.setUsername("ming");
        user.setPassword("78912");
        rabbitTemplate.convertAndSend("exchange-test","test-one",user);
    }


}
