package com.consumerservice01.controller;

import com.bean.User;
import com.consumerservice01.service.AdminServiceImpl;
import com.response.ServiceResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.UUID;

@RestController("admin")
public class AdminController {
    @Resource
    private AdminServiceImpl adminServiceImpl;


    @GetMapping("getadmin")
    public ServiceResult getAdmin() {
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        return adminServiceImpl.getAdmin(s);
    }

    @GetMapping("setadmin")
    public ServiceResult setAdmin() {
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        HashMap<String, Object> hashMap = new HashMap<>();
        return adminServiceImpl.setAdmin(hashMap);
    }

    @GetMapping("asyncAdmin")
    public ServiceResult asyncAdmin() {
        long start = System.currentTimeMillis();
        User user = new User("589","778712@qq.com","1234fgr");
        ServiceResult serviceResult = adminServiceImpl.setUser(user);
        System.out.println(System.currentTimeMillis() - start);
        return serviceResult;
    }


}
