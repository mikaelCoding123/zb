package com.web.demo.controller;

import com.response.ServiceResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web")
public class HelloController {

    @GetMapping("/demo1/{uuid}")
    public String getUUID(@PathVariable("uuid")String UUID){
        ServiceResult serviceResult = new ServiceResult();
        return UUID;
    }

}
