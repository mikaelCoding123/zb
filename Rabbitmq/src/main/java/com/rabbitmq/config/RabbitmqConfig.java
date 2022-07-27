package com.rabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@Configuration
@Slf4j
public class RabbitmqConfig {

    /**
     * 将接受到的数据转成json形式
     * @return
     */
    @Bean
    public MessageConverter messageConverter(){

        return  new Jackson2JsonMessageConverter();
    }

}
