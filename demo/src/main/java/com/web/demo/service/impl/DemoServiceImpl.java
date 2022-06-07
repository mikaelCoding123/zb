package com.web.demo.service.impl;

import com.response.ServiceResult;
import com.web.demo.dao.DemoDao;
import com.web.demo.service.DemoService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    private DemoDao demoDao;

    @Override
    public ServiceResult getDemo(String id) {
        Map<String, String> demoById = demoDao.getDemoById("1");
        ServiceResult serviceResult = new ServiceResult(demoById);
        return serviceResult;
    }

    @Override
    public ServiceResult findDemoByName(String username) {

        return null;
    }
}
