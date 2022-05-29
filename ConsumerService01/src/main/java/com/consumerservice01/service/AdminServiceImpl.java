package com.consumerservice01.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.bean.User;
import com.response.ServiceResult;
import com.service.AdminService;

import java.util.HashMap;

@Service(version = "1.1.0")
public class AdminServiceImpl implements com.service.AdminServiceImpl {

    @Reference(version = "1.0.0",check = false,stub = "")
    AdminService adminService;

    @Override
    public ServiceResult getAdmin(String uuid) {
        ServiceResult admin = adminService.getAdmin(uuid);
        return  admin;
    }

    @Override
    public ServiceResult setAdmin(HashMap<String, Object> paramsMap) {
        HashMap<String, Object> hashMap = new HashMap<>();
        User user = new User();
        user.setPokid("1");
        user.setUsername("jfs@qq.com");
        user.setPassword("777888");
        hashMap.put("2", "abc");
        hashMap.put("4", "abc");
        hashMap.put("6", user);
        adminService.setAdmin(hashMap);

        return null;
    }

    @Override
    public ServiceResult asyncAdmin(String uuid) {
        adminService.getAdmin(uuid);
        adminService.asyncAdmin(uuid);
        return null;
    }

    @Override
    public ServiceResult setUser(User user) {
        ServiceResult serviceResult = adminService.setUser(user);
        return serviceResult;
    }


}
