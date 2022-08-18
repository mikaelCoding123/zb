package com.example.demo.web.service.impl;

import com.example.demo.web.service.RedisService;
import com.response.ServiceResult;
import org.springframework.stereotype.Service;

@Service("RedisService01Impl")
public class RedisService01Impl implements RedisService {


    @Override
    public ServiceResult getRedis() {
        System.out.println("RedisService01===getRedis");
        return null;
    }
}
