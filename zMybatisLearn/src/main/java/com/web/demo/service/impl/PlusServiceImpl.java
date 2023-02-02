package com.web.demo.service.impl;

import com.common.ServiceResult;
import com.web.demo.bo.Admin;
import com.web.demo.dao.AdminDao;
import com.web.demo.dao.AdminDao3;
import com.web.demo.service.PlusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PlusServiceImpl implements PlusService {

    @Resource
    private AdminDao adminDao;
    @Resource
    private AdminDao3 adminDao3;

    @Override
    public ServiceResult insertAdmin() {
        Admin admin = adminDao.selectById("12");
        return ServiceResult.successObject(admin);
    }

    @Override
    public ServiceResult AdminMapper01() {
        Admin admin = adminDao3.selectByPrimaryKey(1L);

        return  ServiceResult.successObject(admin);
    }

    @Override
    public int update() {
        Admin admin1 = new Admin();
        admin1.setPassword("8718273");
        admin1.setUsername("hjkf");
        admin1.setPokid(7687L);
        adminDao3.insertSelective(admin1);
        return 0;
    }
}
