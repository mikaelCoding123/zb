package com.demo.web.demo.controller;

import com.common.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mm")
public class Web03Action {

    private static final Logger log = LoggerFactory.getLogger(Web03Action.class);

    @RequestMapping(value = "/test01",method = RequestMethod.GET)
    public ServiceResult set(){



        return ServiceResult.defaultSuccess();
    }

}
