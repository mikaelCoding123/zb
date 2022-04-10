package com.providerservice01.service;

import cn.hutool.core.util.IdUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.bean.User;
import com.response.ServiceResult;
import com.service.AdminService;
import com.util.ConvertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;

@Service(version = "1.0.0",async = true)
public class AdminServiceImpl implements AdminService {
    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    public ServiceResult getAdmin(String uuid) {
        logger.info(" provoder service01 uuid");
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultObj(uuid);
        return serviceResult;
    }

    @Override
    public ServiceResult setAdmin(HashMap<String, Object> paramsMap) {
        logger.info("providerService01 paramsMap==>{}", paramsMap);
        return null;
    }

    @Override
    public ServiceResult asyncAdmin(String uuid) {

        try {
            Thread.sleep(10000);
            logger.info("uuid====>{}",uuid);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ServiceResult setUser(User user) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultObj("provider01 success");
        logger.info("provider01====>"+user.toString());
        return serviceResult;
    }

}
