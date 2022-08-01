package com.rabbitmq.service;


import com.rabbitmq.bean.User;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class RabbitmqListenerAcTTL {

    @RabbitListener(queues = "test-dead")
    public void AcTWO(Message msg, User user, Channel channel) throws IOException {
        channel.basicAck(msg.getMessageProperties().getDeliveryTag(), false);
        log.info("test-dead====》" + user.toString());
    }

}
