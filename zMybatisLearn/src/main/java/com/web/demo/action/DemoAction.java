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


    @RequestMapping(value = "/demo02",method = RequestMethod.GET)
    public void demo02Action(){
        demoService.demoService02(12+"");
    }

    @RequestMapping(value = "/demo03",method = RequestMethod.GET)
    public void demo03Action(){
        demoService.demoService03(12+"");
    }
}
