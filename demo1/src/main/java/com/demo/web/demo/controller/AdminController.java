package com.demo.web.demo.controller;


import cn.hutool.db.Page;
import com.common.ServiceResult;
import com.demo.web.demo.dao.DemoDao;
import com.services.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    @Resource
    private DemoDao demoDao;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ServiceResult test01(){
        Page page = new Page();
        List<Map<String, String>> maps = demoDao.selectAdmin();

        return new ServiceResult(maps);
    }
}
