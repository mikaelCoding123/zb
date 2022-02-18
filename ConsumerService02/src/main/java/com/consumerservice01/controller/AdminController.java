package com.consumerservice01.controller;

import com.consumerservice01.service.AdminServiceImpl;
import com.response.ServiceResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultMsg(s);
        return serviceResult ;
    }


}
