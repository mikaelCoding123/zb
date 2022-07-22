package com.demo.web.demo.service;

import com.response.ServiceResult;


public interface DemoService {

     ServiceResult getDemo(String id);

     ServiceResult findDemoByName(String username);
     ServiceResult findByid(String id);
}
