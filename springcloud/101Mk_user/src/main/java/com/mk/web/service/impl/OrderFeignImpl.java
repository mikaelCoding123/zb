package com.mk.web.service.impl;

import com.bean.User;
import com.bean.interfaces.MK101use130commonApi;
import com.bean.response.ServiceResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(value = "MKBILL")
public interface OrderFeignImpl extends MK101use130commonApi{

    @GetMapping(value = "/bill/userid/{id}")
    ServiceResult usergetbill(@PathVariable("id") String id);

    @PostMapping(value = "/postbill/userid")
    ServiceResult postusergetbill(@RequestBody User user);

    @PostMapping(value = "balanceTest01/userid")
    com.response.ServiceResult balanceTest01(@RequestBody User user);



}
