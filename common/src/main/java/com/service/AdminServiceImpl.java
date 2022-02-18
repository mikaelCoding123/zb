package com.service;

import com.response.ServiceResult;

import java.util.HashMap;

public interface AdminServiceImpl {
    ServiceResult getAdmin(String uuid);
    ServiceResult setAdmin(HashMap<String, Object> paramsMap);
}
