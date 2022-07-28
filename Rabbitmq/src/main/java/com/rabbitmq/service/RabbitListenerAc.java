package com.rabbitmq.service;

import com.rabbitmq.bean.User;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class RabbitListenerAc {

    /**
     * User 必须有Serializable 跟无参构造
     * 参数类型
     * 1、message message 原生消息详细信息，头+体
     * 2、T<发送的消息的类型> User user
     * 3、Channel channel 当前传输数据的通道
     * @param msg
     * Queue 可以很多人都来监听，只要收到消息，队列删除消息，而且只能有一个收到消息
     * 场景：
     *      1）订单服务启动多个。同一个消息，只能有一个客户端收到
     *      2）只有一个消息完全处理完，方法运行结束，我们就可以接受到下一个消息
     *
     *
     * @RabbitListener
     * @rabbithandle  这个可以看看这么用
     */
    @RabbitListener(queues = {"test-one"})
//    {"pokid":"1231423","username":"ming","password":"78912K2"}
    public void ac(Message msg, User user, Channel channel) {
        byte[] body = msg.getBody();

        MessageProperties messageProperties = msg.getMessageProperties();
        try {

            channel.basicAck(1l, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("====>>>>>" +user.toString());
    }

    @RabbitListener(queues = {"test-two"})
//    {"pokid":"1231423","username":"ming","password":"78912K2"}
    public void ac_consumer(Message msg, User user, Channel channel) {
        byte[] body = msg.getBody();
        MessageProperties messageProperties = msg.getMessageProperties();
        try {
            String messageId = messageProperties.getMessageId();
            channel.basicAck(msg.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("====>>>>>" +user.toString());
    }
}
