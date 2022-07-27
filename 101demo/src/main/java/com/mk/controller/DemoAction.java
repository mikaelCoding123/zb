package com.mk.controller;

import com.response.ServiceResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("web")
@RestController
public class DemoAction {

    @RequestMapping(value = "demo/{uuid}",method = RequestMethod.GET)
    public String getUuid(@PathVariable("uuid")String uuid){
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultMsg("sfssf");
        return uuid;

    }
}
