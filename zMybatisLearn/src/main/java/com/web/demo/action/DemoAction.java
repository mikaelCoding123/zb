package com.web.demo.action;

import com.web.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/demo")
public class DemoAction {
    private static final Logger logger = LoggerFactory.getLogger(DemoAction.class);
    @Resource
    private DemoService demoService;


    @RequestMapping(value = "/demo01", method = RequestMethod.POST)
    public void demo01Action() {
        demoService.demoService("1");
    }


    @RequestMapping(value = "/demo02", method = RequestMethod.GET)
    public void demo02Action() {
        demoService.demoService02(12 + "");
    }

    @RequestMapping(value = "/demo03", method = RequestMethod.GET)
    public void demo03Action() {
        demoService.demoService03(12 + "");
    }

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public void getData() {
        demoService.demoService04();
    }

    //http://localhost:8081/demo/test?txtNum=1234jkfs&name=lkfs
    //可以不用指定method的get还是post方法，但是参数的名字必须跟url中参数一致
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(String txtNum, String name) {
        logger.info("====>" + txtNum);
        logger.info("====>" + name);
        return txtNum + "====" + name;
    }

    @RequestMapping(value = "likeMerge", method = RequestMethod.POST)
    public void test01() {
        demoService.demoService04();
    }


}
