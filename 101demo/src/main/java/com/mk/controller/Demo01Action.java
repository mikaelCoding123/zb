package com.mk.controller;

import com.response.ServiceResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class Demo01Action {

    @GetMapping("test01")
    public ServiceResult test01() {
        System.out.println("test01");
        return new ServiceResult().putMsg("test01");
    }

    @GetMapping("test02")
    public ServiceResult test02() {
        System.out.println("test02");
        return new ServiceResult().putMsg("test02");
    }


    @GetMapping("test03")
    public ServiceResult test03() {
        System.out.println("test03");
        return new ServiceResult().putMsg("test03");
    }

    @GetMapping("test04")
    public ServiceResult test04() {
        System.out.println("test04");
        return new ServiceResult().putMsg("test04");
    }
}
