package com.web.demo.action;

import com.web.demo.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/demo")
public class DemoAction {

    @Resource
    private DemoService demoService;

    @RequestMapping(value = "/demo01", method = RequestMethod.POST)
    public void demo01Action() {
        demoService.demoService("1");

    }
}
