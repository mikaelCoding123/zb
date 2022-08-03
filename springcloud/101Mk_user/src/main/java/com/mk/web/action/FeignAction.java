package com.mk.web.action;


import com.bean.User;
import com.mk.web.service.impl.OrderFeignImpl;
import com.response.ServiceResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("feign")
public class FeignAction {
    @Resource
    private OrderFeignImpl orderFeign;

    @GetMapping("balance01")
    public ServiceResult test01(){
        User user = new User();
        user.setUserid("111");
        ServiceResult serviceResult = orderFeign.balanceTest01(user);
        return serviceResult;
    }
}
