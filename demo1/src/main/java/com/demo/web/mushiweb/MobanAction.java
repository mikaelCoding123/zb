package com.demo.web.mushiweb;

import com.bean.User;
import com.common.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MobanAction {

    private static final Logger log = LoggerFactory.getLogger(MobanAction.class);

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public void test(@RequestBody User object) {
        String uuids = "";
        for (int i = 0; i < object.getPc().size(); i++) {
            String s = "'" + (String) object.getPc().get(i) + "'";
            uuids += s + ",";
        }
        log.info(uuids.substring(0, uuids.lastIndexOf(",")));
        return ;
    }

    @RequestMapping(value = "/listAdmin",method = RequestMethod.GET)
    public ServiceResult test01(){



        return new ServiceResult();
    }

}
