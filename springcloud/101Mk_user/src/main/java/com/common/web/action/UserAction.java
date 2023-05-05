package com.common.web.action;


import com.bean.User;
import com.common.web.bo.MkUser;
import com.common.web.service.UserService;
import com.common.web.service.impl.OrderFeignImpl;
import com.response.ServiceResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class UserAction {

    @Resource
    private UserService userService;

    @Resource
    private OrderFeignImpl orderFeign;


    @PostMapping("login")
    public ServiceResult doLogin(@RequestBody @Validated MkUser user){
        ServiceResult serviceResult = userService.login(user);
        return serviceResult;
    }
    @PostMapping("register")
    public ServiceResult doRegister(@RequestBody @Validated MkUser user){
        ServiceResult register = userService.register(user);
        return register;
    }

    @PostMapping("getOrder/{userid}")
    public ServiceResult getOrder(@PathVariable("userid") String useid){
//        userService.getOrder();

        return null;
    }

    @PostMapping("/feign/userid")
    public ServiceResult getBill(@RequestBody String userid){
        User user = new User();
        user.setUserid("u8791");
        user.setUsername("hua");
        user.setPassword("1234");
        System.out.println(user.toString());
        com.bean.response.ServiceResult usergetbill = orderFeign.usergetbill(user.toString());
        com.bean.response.ServiceResult postusergetbill = orderFeign.postusergetbill(user);
        System.out.println("");
        return null;
    }


}
