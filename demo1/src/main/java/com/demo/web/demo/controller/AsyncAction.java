package com.demo.web.demo.controller;

import com.common.ServiceResult;

import com.enumcode.CodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/asy")
public class AsyncAction {

    private static final Logger log = LoggerFactory.getLogger(AsyncAction.class);

    @Async
    @RequestMapping(value = "/test01", method = RequestMethod.POST)
    public ServiceResult ays01(@RequestBody Object o) {
        log.info(o.toString() + "===========");
        ServiceResult.defaultSuccess();
//        try {
//            Thread.sleep(1_000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.info("test01====");
        return ServiceResult.setEnum(CodeEnum.SUCCESS, "hfeowjfl");
    }


}
