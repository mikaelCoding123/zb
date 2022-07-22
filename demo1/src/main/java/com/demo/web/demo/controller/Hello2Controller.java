package com.demo.web.demo.controller;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.web.demo.service.DemoService;
import com.response.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.ServerEndpoint;

@RestController
@RequestMapping("/web2")
public class Hello2Controller {
    private static final Logger logger = LoggerFactory.getLogger(Hello2Controller.class);

    @Autowired
    public DemoService demoService;

    @RequestMapping(value = "demo", method = RequestMethod.POST)
    public ServiceResult demo() {
        logger.info("web2/demo");
        return null;
    }

    @RequestMapping(value = "mybatis01",method = RequestMethod.POST)
    public ServiceResult post01(@RequestBody JSONObject json){
        demoService.findByid("1");


        return null;
    }

}
