package com.demo.web.demo.service.impl;

import com.demo.web.demo.dao.DemoDao;
import com.demo.web.demo.service.DemoService;
import com.response.ServiceResult;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    private DemoDao demoDao;

//    @Resource
//    private ThreadPoolExecutor threadPoolExecutor;

    @Override
    public ServiceResult getDemo(String id) {
        Map<String, String> demoById = demoDao.getDemoById("1");
        ServiceResult serviceResult = new ServiceResult(demoById);
        return serviceResult;
    }

    @Override
    public ServiceResult findDemoByName(String username) {
//        threadPoolExecutor.execute(()->{
//            System.out.println("1233");
//        });

        return null;
    }
}
