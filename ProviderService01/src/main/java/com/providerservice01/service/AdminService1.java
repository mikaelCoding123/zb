package com.providerservice01.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AdminService1 implements AdminService {
    private static final Logger logger = LoggerFactory.getLogger(AdminService1.class);

    public String getAdmin(String uuid){
        logger.info("uuid");
        return "providerService01\t"+uuid;
    }

}
