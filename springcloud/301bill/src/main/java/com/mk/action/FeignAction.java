package com.mk.action;


import com.bean.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.response.ServiceResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class FeignAction {

    @Value("${server.port}")
    private String pore;

    @GetMapping("bill/userid/{id}")
    public ServiceResult usergetbill(@PathVariable("id")String id) {
        ServiceResult serviceResult = new ServiceResult();
        System.out.println("====>"+id);
        return serviceResult.putMsg("get 200");
    }

    @PostMapping("postbill/userid")
    public ServiceResult usergetbill(@RequestBody User user) {
        ServiceResult serviceResult = new ServiceResult();
        System.out.println("====>"+user.toString());
        return serviceResult.putMsg("post 200");
    }

    @PostMapping("balanceTest01/userid")
    public ServiceResult balanceTest01(@RequestBody User user) {
        ServiceResult serviceResult = new ServiceResult();
        System.out.println("====>"+user.toString());
        try {
            Thread.sleep(15_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serviceResult.putMsg("post "+pore);
    }

    public ServiceResult fallbacktest01(){
        System.out.println("超时====》");
        return null;
    }
}
