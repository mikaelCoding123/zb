package com.web.demo.action;

import com.common.ServiceResult;
import com.web.demo.service.PlusService;
import org.springframework.util.DigestUtils;
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

            System.out.println(DigestUtils.md5DigestAsHex("key".toString().getBytes()));
        return serviceResult;
    }

    public static void main(String[] args) {
//        System.out.println(new String(DigestUtil.sha256Hex("hua")));
//        System.out.println(DigestUtil.bcrypt("110"));
//        System.out.println(DigestUtil.bcryptCheck("110", "$2a$10$egemTwPgFZZhczT23IACkeptfAdUSSZXZTPIQ7VKqF8PyP5hqYnuu"));
//        ServiceResult serviceResult = JSON.parseObject("{\n" +
//                "  \"code\": \"99999\",\n" +
//                "  \"msg\": \"系统错误\",\n" +
//                "  \"data\": null,\n" +
//                "  \"flag\": true\n" +
//                "}", ServiceResult.class);
//        System.out.println(serviceResult);
    }

}
