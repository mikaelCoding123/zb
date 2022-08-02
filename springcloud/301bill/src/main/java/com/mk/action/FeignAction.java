package com.mk.action;


import com.bean.User;
import com.response.ServiceResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class FeignAction {

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
}
