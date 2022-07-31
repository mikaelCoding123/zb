package com.mk.web.service.impl;

import com.mk.web.bo.MkUser;
import com.mk.web.dao.MkUserDao;
import com.mk.web.service.UserService;
import com.response.ServiceResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource
    public MkUserDao mkUserDao;

    @Override
    public ServiceResult login(MkUser mkUser) {
        int i = mkUserDao.selectOne(mkUser);
        if (i == 0) {
            return new ServiceResult().putMsg("账号或者密码不对，请核准后重新输入！").putCode("999999");
        }
        return new ServiceResult().putMsg("登录成功！");
    }

    @Override
    public ServiceResult register(MkUser mkUser) {

        int insert = mkUserDao.insert(mkUser);
        if (insert==0){
            return new ServiceResult().putMsg("注册失败！").putCode("999999");
        }
        return new ServiceResult().putMsg("注册成功！");
    }
}
