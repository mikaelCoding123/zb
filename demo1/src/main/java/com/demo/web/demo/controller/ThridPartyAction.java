package com.demo.web.demo.controller;

import com.common.ServiceResult;
import com.demo.web.utils.JwtUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("appid")
public class ThridPartyAction {

    private final static String appid="ad1a32d13158ef70c2cec5c38706d125306aa979115776c5c5ed0eeacda03aead1edd156e35aa84453bcf120e30e7a23ab8e2cb7ab88760b1c8c70f31c1b001e6b0d93f73f106d5fc299062bf4822e7c04921b8f807d64241cd7bc9b1c5632279a2d9bb5e4c0b";

    @Resource
    private JwtUtil jwtUtil;

    @RequestMapping(value = "/demo01", method = RequestMethod.POST)
    public ServiceResult postDemo01(@RequestBody Map<String,Object> parameters){




        return null;

    }

    public static void main(String[] args) {

    }
}
