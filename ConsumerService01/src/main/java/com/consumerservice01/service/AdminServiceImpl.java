package com.consumerservice01.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {

    @Reference(check = false,stub = "")
    AdminService adminService;

    @Override
    public String getAdmin(String uuid) {

        return adminService.getAdmin(uuid);
    }


}
