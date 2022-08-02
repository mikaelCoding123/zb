package com.mk.web.service;

import com.bean.User;
import com.response.ServiceResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient("MK_BILL")
public interface DofeignBlance {

    @PostMapping("user/test01")
    ServiceResult test01(User user);

}
