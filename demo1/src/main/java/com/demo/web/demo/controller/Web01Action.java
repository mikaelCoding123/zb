package com.demo.web.demo.controller;

import com.demo.web.demo.service.CalacService;
import com.response.ServiceResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class Web01Action {

    @Resource
    private List<CalacService> calacServiceList;

    /**
     * 策略模式
     *
     * @param params
     * @return ServiceResult
     */
    @RequestMapping(value = "calc", method = RequestMethod.POST)
    public ServiceResult calac(@RequestBody Map<String, String> params) {
        CalacService calacService = calacServiceList.stream().filter(a ->
                a.changeCalac(params.get("type"))
        ).findFirst().orElse(null);
        if (calacService == null) {
            return null;
        }
        return calacService.calac(params);

    }

}
