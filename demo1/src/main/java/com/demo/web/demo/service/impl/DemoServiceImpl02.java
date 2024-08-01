package com.demo.web.demo.service.impl;

import com.common.Result;
import com.demo.web.demo.service.DemoService;
import com.response.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("DemoServiceImpl02")
@Primary
public class DemoServiceImpl02 implements DemoService {
    private static final Logger log = LoggerFactory.getLogger(DemoServiceImpl02.class);
    @Override
    public ServiceResult getDemo(String id) {
        return null;
    }

    @Override
    public ServiceResult findDemoByName(String username) {
        return null;
    }

    @Override
    public ServiceResult findByid(String id) {
        return null;
    }

    @Override
    public ServiceResult insertIP(Map<String, String> paramsMap) {
        return null;
    }

    @Override
    public ServiceResult insertLogs() {
        return null;
    }

    @Override
    public Result selectUser() {
        log.info("this is DemoServiceImpl02 ");
        return null;
    }

    @Override
    public Result selectlist() {
        return null;
    }
}
