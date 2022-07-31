package com.mk.web.action;



import com.mk.web.bo.MkUser;
import com.mk.web.service.UserService;
import com.mk.web.service.impl.OrderFeignImpl;
import com.mk.web.service.impl.UserServiceImpl;
import com.response.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
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


}
