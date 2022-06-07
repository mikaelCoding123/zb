package com.web.demo.controller;

import com.bean.User;
import com.response.ServiceResult;
import com.web.demo.bo.DemoBo;
import com.web.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@RestController
@RequestMapping("/web")
@SessionAttributes("user")
public class HelloController {

    @Value("${hkey}")
    private String  hkey;

    @Resource
    private DemoService demoService;

    @GetMapping("/demo1/{uuid}")
    public String getUUID(@PathVariable("uuid") String UUID, @ModelAttribute("user") User user) {
        ServiceResult serviceResult = new ServiceResult();
        ServiceResult demo = demoService.getDemo("1");

        System.out.println(user.getPassword() + "====="+hkey);
        System.out.println(demo);
        return UUID;
    }

    @GetMapping("fisrtVoid")
    public ServiceResult fisrtVoid(HttpServletRequest request) {
        User user = new User();
        user.setPokid("988");
        user.setUsername("luo");
        user.setPassword("iiii");
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return null;
    }
    @GetMapping("secondVoid")
    public ServiceResult getSecondV(){
        System.out.println(hkey);

        return null;
    }
    @PostMapping("/postBo")
    public ServiceResult postBoVoid(@RequestBody DemoBo demo){

        System.out.println(demo.getPokid()+"-------");
        return null;
    }

}
