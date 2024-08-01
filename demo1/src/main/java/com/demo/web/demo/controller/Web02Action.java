package com.demo.web.demo.controller;

import cn.hutool.http.server.HttpServerResponse;
import com.common.Result;
import com.common.ServiceResult;
import com.demo.web.demo.bo.CodeDo;
import com.demo.web.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("web2")
public class Web02Action {
    //通过byname来获取指定的bean
    //在Impl类中添加@Service("DemoServiceImpl02")
    //@Primary这2个注解
    @Resource(name = "DemoServiceImpl02")
    private DemoService demoService;


    @RequestMapping("demo01")
    public ServiceResult getWeb2() {
        Map getcode = CodeDo.getcode("99999");
        return ServiceResult.setErrorMap(getcode);
    }


    //    ResponseEntity除非有特殊要求必修返回statue时才考虑使用
    @RequestMapping("demo02")
    public ResponseEntity getWeb3(HttpServerResponse response) {

        Map getcode = CodeDo.getcode("99999");
        ResponseEntity responseEntity = new ResponseEntity<>("getcode", HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/demo03", method = RequestMethod.GET)
    public ServiceResult testWeb3() {

        Result result = demoService.selectUser();
        ServiceResult serviceResult = ServiceResult.successObject(result);

        return serviceResult;
    }


}
