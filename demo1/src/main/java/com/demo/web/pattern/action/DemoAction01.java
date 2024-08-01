package com.demo.web.pattern.action;


import com.common.ServiceResult;
import com.demo.web.demo.bo.RpcBody;
import com.demo.web.pattern.service.DemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("pattern")
public class DemoAction01 {


    @Resource(name = "DemoServiceImpl01")
    private DemoService demoService;

    @RequestMapping(value = "/test01", method = RequestMethod.GET)
    public ServiceResult test01(@RequestBody @Validated RpcBody rpcBody) {
        String pid = rpcBody.getPid();

        return demoService.service(pid, rpcBody);


    }

    public static void main(String[] args) {

    }

}
