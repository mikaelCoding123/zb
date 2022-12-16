package com.service;

import com.alibaba.fastjson.JSON;
import com.common.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RocketMQTransactionListener(txProducerGroup = "12Group")
public class first01 implements RocketMQLocalTransactionListener {

    /**
     * 处理本地事务
     *
     * @param message
     * @param o       传参的字段
     * @return
     */
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        System.out.println("executeLocalTransaction");
        log.info("message===>" + message.toString());
        log.info("o=====>" + o.toString());
        ServiceResult serviceResult = JSON.parseObject(JSON.toJSONString(o), ServiceResult.class);
        log.info(serviceResult.toString());
        return RocketMQLocalTransactionState.COMMIT;
    }

    /**
     * 回调方法，查看本地事务是否完成
     *
     * @param message
     * @return
     */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        log.info("message======>>>>" + message.toString());
        return RocketMQLocalTransactionState.ROLLBACK;
    }
}
