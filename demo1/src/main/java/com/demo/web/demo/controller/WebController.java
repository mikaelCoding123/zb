package com.demo.web.demo.controller;

import com.common.Result;
import com.demo.web.demo.service.DemoService;
import com.enumcode.CodeEnum;
import com.github.pagehelper.PageInfo;
import com.response.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
public class WebController {
    private static final Logger logger = LoggerFactory.getLogger(WebController.class);
    @Resource(name = "DemoServiceImpl")
    private DemoService demoService;

    @RequestMapping(value = "insertDdmin", method = RequestMethod.GET)
    public ServiceResult insertDemo() {
        HashMap<String, String> hashMap = new HashMap<>();
        demoService.insertIP(hashMap);
        return null;
    }

    //http://localhost:8081/demo/test?txtNum=1234jkfs&name=lkfs
    //可以不用指定method的get还是post方法，但是参数的名字必须跟url中参数一致
    @RequestMapping(value = "/test")
    public String getWf(String txtNum, String name) {

        logger.info("name====>" + txtNum);
        logger.info("name====>" + name);
        return txtNum + "=======" + name;

    }

    @RequestMapping(value = "insterLogs",method = RequestMethod.GET)
    public void insertLogs(){
        demoService.insertLogs();
    }

    /**
     * mysql几种数剧类型查出来的效果
     * @return
     */
    @RequestMapping(value = "selectUser",method = RequestMethod.GET)
    public Result selectUser(){
        Result result = demoService.selectUser();
        return result;
    }


    @RequestMapping(value = "/Admin",method = RequestMethod.GET)
    public Result selectAdmin(){

        Result selectlist = demoService.selectlist();



        return Result.setCodeEnum(CodeEnum.SUCCESS,selectlist);
    }


}
