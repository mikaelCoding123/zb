package com.web.demo.service.impl;

import com.web.demo.bo.Admin;
import com.web.demo.dao.AdminDao;
import com.web.demo.service.OtherService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Service
public class OtherServiceImpl implements OtherService {
    @Resource
    private AdminDao adminDao;

    @PostConstruct
    @Override
    public void query() {
        Admin admin = adminDao.selectByPrimaryKey(1L);
        System.out.println(admin.getPassword().toString());
    }
}
