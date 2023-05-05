package com.common.web.service;


import com.common.web.bo.MkUser;
import com.response.ServiceResult;

public interface UserService {
    public ServiceResult login(MkUser mkUser);
    ServiceResult register(MkUser mkUser);
}
