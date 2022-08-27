package com.mk.controller;

import com.response.ServiceResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("web")
@RestController
public class DemoAction {

    @RequestMapping(value = "demo/{uuid}",method = RequestMethod.GET)
    public String getUuid(@PathVariable("uuid")String uuid){
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultMsg("sfssf");
        return uuid;

    }
    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public @ResponseBody String getAction(@RequestBody Map map, HttpServletRequest httpServletRequest){
        System.out.println("map===>"+map);
        return "";
    }


}
