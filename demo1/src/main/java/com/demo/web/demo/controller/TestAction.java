package com.demo.web.demo.controller;

import com.demo.web.config.AccessLimit;
import com.response.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestAction {

    private static final Logger log = LoggerFactory.getLogger(TestAction.class);

    @AccessLimit(seconds = 10, maxCount = 4)
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ServiceResult test() {

        log.info("ttttttttttt");
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultMsg("ttttt");
        return serviceResult;
    }
}
