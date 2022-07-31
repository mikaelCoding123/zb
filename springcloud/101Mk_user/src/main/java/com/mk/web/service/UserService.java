package com.mk.web.service;


import com.mk.web.bo.MkUser;
import com.response.ServiceResult;

public interface UserService {
    public ServiceResult login(MkUser mkUser);
    ServiceResult register(MkUser mkUser);
}
