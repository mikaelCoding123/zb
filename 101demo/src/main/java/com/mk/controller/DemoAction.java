package com.mk.controller;

import com.response.ServiceResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("web")
@RestController
public class DemoAction {

    @RequestMapping(value = "demo/{uuid}", method = RequestMethod.GET)
    public String getUuid(@PathVariable("uuid") String uuid) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultMsg("sfssf");
        return uuid;

    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public @ResponseBody
    String getAction(@RequestBody Map map, HttpServletRequest httpServletRequest) {
        System.out.println("map===>" + map);
        return "";
    }

    //http://localhost:11010/web/demo?dm=123&uuid=hfsu&name=更何况
    //{dm=123, uuid=hfsu, name=更何况}
    @GetMapping("/demo")
    public String getDemo(@RequestParam Map<String, String> bo) {
        System.out.println(bo.toString());
        return "";
    }


}
