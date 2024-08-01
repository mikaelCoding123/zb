package com.demo.web.demo.service.impl;

import com.bean.User;
import com.common.Result;
import com.demo.web.demo.bo.Admin;
import com.demo.web.demo.dao.DemoDao;
import com.demo.web.demo.dao.DemoMapper;
import com.demo.web.demo.service.DemoService;
import com.enumcode.CodeEnum;
import com.response.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;

@Service("DemoServiceImpl")
public class DemoServiceImpl implements DemoService {
    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);
    @Resource
    private DemoDao demoDao;

    @Resource
    private DemoMapper demoMapper;

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

    @Override
    public ServiceResult findByid(String id) {
        List<Map<String, String>> maps = demoDao.selectAdmin1();

        return null;
    }

    /**
     * ip，time存储和select
     *
     * @param paramsMap1
     * @return
     */
    @Override
    public ServiceResult insertIP(Map<String, String> paramsMap1) {
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("pokid", new Random().nextInt(1000));
        paramsMap.put("ip", "192.168.1.10");
        paramsMap.put("datetime", LocalDateTime.now().toString());
        paramsMap.put("date", LocalDateTime.now().toString());
        paramsMap.put("date_time", LocalDateTime.now().toString());
        demoDao.insetDemo(paramsMap);
        List<Map<String, Object>> objectMap = demoDao.selectIP();
        objectMap.stream().forEach((a) -> {

            System.out.println(a.toString());
        });
        return null;
    }

    @Override
    public ServiceResult insertLogs() {
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setUsername("logs" + i);
            user.setPassword("123");
            user.setPokid(UUID.randomUUID().toString());
            demoDao.insertlogs(UUID.randomUUID().toString(), user.toString());
        }

        return null;
    }

    @Override
    public Result selectUser() {
        List<Map<String, Object>> maps = demoDao.selectSomething();
        return Result.setCodeEnum(CodeEnum.SUCCESS, maps);

    }

    @Override
    public Result selectlist() {
        List<Admin> list = demoDao.selectList();

        return Result.setCodeEnum(CodeEnum.SUCCESS,list);
    }

    //测试logback.xml是否可以分割日志
//    @Scheduled(cron = "30 10 1 * * ?")
    public void test() {
        int i = 0;
        while (1000000 > i) {
            logger.info("=====>" + UUID.randomUUID().toString());
            i++;
        }
    }

}
