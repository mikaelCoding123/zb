package com.providerservice01.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.response.ServiceResult;
import com.service.AdminService;
import com.util.ConvertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;

@Service
public class AdminService1 implements AdminService {
    private static final Logger logger = LoggerFactory.getLogger(AdminService1.class);

    public ServiceResult getAdmin(String uuid) {
        logger.info("uuid");
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultObj(uuid);
        return serviceResult;
    }

    @Override
    public ServiceResult setAdmin(HashMap<String, Object> paramsMap) {
        logger.info("providerService01 paramsMap==>{}", paramsMap);
        logger.info(ConvertUtil.moneyToChinese(new BigDecimal("1897.78")));
        return null;
    }

}
