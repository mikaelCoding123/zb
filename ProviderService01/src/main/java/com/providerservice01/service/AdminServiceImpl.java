package com.providerservice01.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.bean.User;
import com.response.ServiceResult;
import com.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

@Service(version = "1.0.0")
public class AdminServiceImpl implements AdminService {

    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
    private static   int i = 0;
    public ServiceResult getAdmin(String uuid) {
            i=i+1;
        logger.info(" provoder service01 uuid==》" + uuid);
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultObj("provoder service01 uuid=" + uuid);
        System.out.println(i);
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
            logger.info("uuid====>{}", uuid);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ServiceResult setUser(User user) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultObj("provider01 success");
        logger.info("provider01====>" + user.toString());
        return serviceResult;
    }

}
