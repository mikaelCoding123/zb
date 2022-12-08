package com.demo.web.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.web.config.AccessLimit;
import com.google.gson.Gson;
import com.response.ServiceResult;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
public class TestAction {

    private static final Logger log = LoggerFactory.getLogger(TestAction.class);

    @AccessLimit(seconds = 10, maxCount = 4)
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ServiceResult test() {

        log.info("ttttttttttt");
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultMsg("ttttt");
        return serviceResult;
    }

    @RequestMapping(value = "json",method = RequestMethod.POST)
    @SneakyThrows
    public void test01(@RequestBody Map<String, String> params){
        String s = params.toString();
        Assert.isNull(params.get("username"), "不能为空");
        String s1 = JSONObject.toJSONString(params);
        Map jsonObject = JSONObject.parseObject(s1,Map.class);
        log.info(params.toString());
        String json = "{\"abc\":\"1\",\"hahah\":\"2\"}";
        log.info(jsonObject.toString());
    }
}
