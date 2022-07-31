package com.mk.web.service.impl;

import com.bean.response.ServiceResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

@Component
@FeignClient("MK-ORDER")
public interface OrderFeignImpl {



    @GetMapping("/getOrderid/{userid}")
    public  ServiceResult getOrderid(@PathVariable("userid") String userid);
}
