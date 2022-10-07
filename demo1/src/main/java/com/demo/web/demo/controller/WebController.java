package com.demo.web.demo.controller;

import com.demo.web.demo.service.DemoService;
import com.response.ServiceResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController("web")
public class WebController {

    @Resource
    private DemoService demoService;

    @RequestMapping(value = "insertDdmin", method = RequestMethod.GET)
    public ServiceResult insertDemo() {
        HashMap<String, String> hashMap = new HashMap<>();
        demoService.insertIP(hashMap);
        return null;
    }
}
