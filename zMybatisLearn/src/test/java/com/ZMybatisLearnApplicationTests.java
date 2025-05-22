package com;

import cn.hutool.core.lang.Tuple;
import cn.hutool.core.util.ObjectUtil;
import com.bean.User;

import com.enumcode.MsgEnum;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class ZMybatisLearnApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(ZMybatisLearnApplicationTests.class);

    @Test
    void contextLoads() {
        log.info("test===>");
        Tuple objects = new Tuple("a1", "a2");
        User user = new User();
        boolean emptyIfStr = ObjectUtil.isNull(user.getPassword());
        System.out.println(emptyIfStr);
        //expresssion为false时抛出msg内容
        Assert.isTrue(1!=0, MsgEnum.msg01.getMsg_1());
    }

}
