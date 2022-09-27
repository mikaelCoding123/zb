package com.mk.web.action;

import com.response.ServiceResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestAction {


    @RequestMapping(value = "/one",method = RequestMethod.GET)
    public ServiceResult getOne(){

        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultMsg("one...101mk_user服务 ");
        return serviceResult;
    }
}
