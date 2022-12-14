package com.demo.web.demo.service.impl;

import com.demo.web.demo.bo.CodeDo;
import com.demo.web.demo.dao.DemoDao;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class OthreServiceImpl {
    @Resource
    private DemoDao demoDao;

    @Resource
    private CodeDo codeDo;

    @PostConstruct
    @Order(1)
    public void setCodeEnum(){
        List<Map<String, String>> maps = demoDao.selectCodeEnum();
        codeDo.setCode(maps);
    }
}
