package com.common.web.service.impl;

import com.common.web.bo.MkUser;
import com.common.web.dao.MkUserDao;
import com.common.web.service.UserService;
import com.response.ServiceResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.ZonedDateTime;

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

    public static void main(String[] args) {
        //这个ZonedDateTime可以获取after的时间
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }

}
