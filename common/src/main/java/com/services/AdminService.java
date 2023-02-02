package com.services;


import com.bean.User;
import com.response.ServiceResult;

import java.util.HashMap;

public interface AdminService {
    ServiceResult getAdmin(String uuid);
    ServiceResult setAdmin(HashMap<String, Object> paramsMap);
    ServiceResult asyncAdmin(String uuid);
    ServiceResult setUser(User user);
}
