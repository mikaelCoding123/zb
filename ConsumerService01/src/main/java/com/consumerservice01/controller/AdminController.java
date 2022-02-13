package com.consumerservice01.controller;

import com.consumerservice01.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController("admin")
public class AdminController {
    @Resource
   private AdminServiceImpl adminServiceImpl;


    @GetMapping("getadmin")
    public String getAdmin() {
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        return adminServiceImpl.getAdmin(s);
    }


}
