package com.web.demo.service.impl;

import com.enumcode.CodeEnum;
import com.common.ServiceResult;
import com.web.demo.bo.Admin;
import com.web.demo.dao.AdminDao;
import com.web.demo.service.PlusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PlusServiceImpl implements PlusService {

    @Resource
    private AdminDao adminDao;

    @Override
    public ServiceResult insertAdmin() {
        Admin admin = adminDao.selectById("12");
        return ServiceResult.success(CodeEnum.SUCCESS,admin);
    }
}
