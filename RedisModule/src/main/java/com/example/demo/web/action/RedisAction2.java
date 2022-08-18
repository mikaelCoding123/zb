package com.example.demo.web.action;


import com.example.demo.web.service.RedisService;
import com.response.ServiceResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisAction2 {

    @Resource(name = "RedisService01Impl")
    private RedisService redisService;

    @RequestMapping("api/redis/test01")
    public ServiceResult getway01(){

        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultMsg("api/test01");
        return serviceResult;
    }

    @RequestMapping(value = "api/redis/test02",method = RequestMethod.GET)
    public ServiceResult getway02(){

        return redisService.getRedis();
    }
}
