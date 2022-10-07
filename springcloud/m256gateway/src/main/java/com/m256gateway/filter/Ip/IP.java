package com.m256gateway.filter.Ip;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
public class IP {

    @Resource
    private  IPDao ipDao;

    @PostConstruct
    public void getIP(){
        List<Map<String, String>> ip = ipDao.getIP();
        System.out.println(ip.toString());
    }
}
