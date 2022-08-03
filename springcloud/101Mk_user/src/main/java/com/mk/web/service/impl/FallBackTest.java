package com.mk.web.service.impl;

import com.bean.User;
import com.response.ServiceResult;
import org.springframework.stereotype.Component;

@Component
public class FallBackTest implements OrderFeignImpl{
    @Override
    public ServiceResult usergetbill(String id) {
        return null;
    }

    @Override
    public ServiceResult postusergetbill(User user) {
        return null;
    }

    @Override
    public ServiceResult balanceTest01(User user) {
        System.out.println("balanceTest01 feign接口报错！！");
        return null;
    }
}
