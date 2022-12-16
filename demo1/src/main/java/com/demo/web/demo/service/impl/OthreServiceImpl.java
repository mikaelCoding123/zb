package com.demo.web.demo.service.impl;

import com.demo.web.demo.bo.CodeDo;
import com.demo.web.demo.dao.DemoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class OthreServiceImpl {

    private static final Logger log = LoggerFactory.getLogger(OthreServiceImpl.class);
    @Resource
    private DemoDao demoDao;

    @Resource
    private CodeDo codeDo;

    /**
     * 2个PostConstruct时没有先后，只看哪个先执行
     */
    @PostConstruct
    public void setCodeEnum() {
        List<Map<String, String>> maps = demoDao.selectCodeEnum();
        codeDo.setCode(maps);
    }

    @PostConstruct
    public void test() {
        log.info("PostConstruct====>");
    }
}
