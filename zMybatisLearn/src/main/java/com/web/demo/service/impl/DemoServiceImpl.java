package com.web.demo.service.impl;

import com.web.demo.bo.Admin;
import com.web.demo.dao.AdminDao;
import com.web.demo.service.DemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DemoServiceImpl implements DemoService {
    @Resource
    private AdminDao adminDao;

    @Override
    public void demoService(String id) {
        Admin admin = adminDao.selectByPrimaryKey(1L);
        System.out.println(admin);
    }
}
