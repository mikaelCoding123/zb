package com.demo.web.demo.service;

import com.response.ServiceResult;

import java.util.Map;

public interface CalacService {
   boolean changeCalac(String type);
   ServiceResult calac(Map<String,String> params);
}
