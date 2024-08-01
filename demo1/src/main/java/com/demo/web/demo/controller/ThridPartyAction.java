package com.demo.web.demo.controller;

import com.common.ServiceResult;
import com.demo.web.demo.bo.RpcBody;
import com.demo.web.utils.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("appid")
public class ThridPartyAction {
    private static final Logger log = LoggerFactory.getLogger(ThridPartyAction.class);

    private final static String appid="ad1a32d13158ef70c2cec5c38706d125306aa979115776c5c5ed0eeacda03aead1edd156e35aa84453bcf120e30e7a23ab8e2cb7ab88760b1c8c70f31c1b001e6b0d93f73f106d5fc299062bf4822e7c04921b8f807d64241cd7bc9b1c5632279a2d9bb5e4c0b";

    @Resource
    private JwtUtil jwtUtil;

    @RequestMapping(value = "/demo01", method = RequestMethod.POST)
    public ServiceResult postDemo01(@RequestBody Map<String,Object> parameters){




        return null;

    }


    //进行级联检查嵌套对象（@Validated @RequestBody这个2个注解)
    @RequestMapping(value = "/demo02", method = RequestMethod.POST)
    public ServiceResult postDemo02(@Validated @RequestBody RpcBody parameters){
        StopWatch stopWatch = new StopWatch(parameters.getPid());
        stopWatch.start();
        //打印入参
        log.info("可以==={}",parameters.toString());


        stopWatch.stop();
        log.info(stopWatch.getId()+stopWatch.getTotalTimeSeconds());
        return null;

    }




    public static void main(String[] args) {

    }
}
