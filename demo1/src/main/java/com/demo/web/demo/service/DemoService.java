package com.demo.web.demo.service;

import com.response.ServiceResult;

import java.util.Map;


public interface DemoService {

     ServiceResult getDemo(String id);

     ServiceResult findDemoByName(String username);
     ServiceResult findByid(String id);

     ServiceResult insertIP(Map<String,String> paramsMap);

     ServiceResult insertLogs();
}
