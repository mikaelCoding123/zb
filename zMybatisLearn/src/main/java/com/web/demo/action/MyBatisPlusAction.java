package com.web.demo.action;

import com.common.ServiceResult;
import com.web.demo.service.PlusService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MyBatisPlusAction {

    @Resource
    private PlusService plusService;

    @RequestMapping(value = "/plus", method = RequestMethod.GET)
    public ServiceResult plusAction() {
        ServiceResult serviceResult = plusService.insertAdmin();

//            System.out.println(DigestUtils.md5DigestAsHex("key".toString().getBytes()));
        return serviceResult;
    }

}
