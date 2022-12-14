package com.demo.web.demo.controller;

import com.common.ServiceResult;
import com.demo.web.demo.bo.CodeDo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("web2")
public class Web02Action {


    @RequestMapping("demo01")
    public ServiceResult getWeb2(){
        Map getcode = CodeDo.getcode("99999");
        return ServiceResult.setErrorMap(getcode);
    }



}
