package com.demo.web.demo.controller;

import com.response.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web2")
public class Hello2Controller {
    private static final Logger logger = LoggerFactory.getLogger(Hello2Controller.class);
    @RequestMapping(value = "demo",method = RequestMethod.POST)
    public ServiceResult demo(){
        logger.info("web2/demo");
        return null;
    }
}
