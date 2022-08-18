package com.example.demo.web.service.impl;

import com.example.demo.web.service.RedisService;
import com.response.ServiceResult;
import org.springframework.stereotype.Service;

@Service("RedisServiceImpl")
public class RedisServiceImpl implements RedisService {
    @Override
    public ServiceResult getRedis() {
        System.out.println("RedisServiceImpl===getRedis()");
        return null;
    }
}
