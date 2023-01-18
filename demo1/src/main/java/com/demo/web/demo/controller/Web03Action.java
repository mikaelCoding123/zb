package com.demo.web.demo.controller;

import cn.hutool.core.lang.UUID;
import com.bean.User;
import com.common.Result;
import com.enumcode.MsgEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mm")
public class Web03Action {

    private static final Logger log = LoggerFactory.getLogger(Web03Action.class);

    @RequestMapping(value = "/test01",method = RequestMethod.GET)
    public Object set(){

        return Result.defaultSuccess();
    }

    @RequestMapping(value = "/test02",method = RequestMethod.GET)
    public Object set02(){
        User user = new User();
        user.setUsername("jfl");
        user.setPassword("97");
        user.setPokid(UUID.fastUUID().toString());
        return user;
    }
    @RequestMapping(value = "/test03",method = RequestMethod.GET)
    public Object set03(){
        User user = new User();
        user.setUsername("jfl");
        user.setPassword("97");
        user.setPokid(UUID.fastUUID().toString());
        int i = 1/0;
        throw new RuntimeException(MsgEnum.exception.getMsg_1());
    }

}
