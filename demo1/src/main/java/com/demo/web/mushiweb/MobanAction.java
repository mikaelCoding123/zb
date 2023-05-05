package com.demo.web.mushiweb;

import com.common.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class MobanAction {
    private static final Logger log = LoggerFactory.getLogger(MobanAction.class);

    @RequestMapping(value = "/test01", method = RequestMethod.GET)
    public void test(@PathParam("a") String a, @PathParam("b") String b, @PathParam("c") String c, @PathParam("d") String d) {
        log.info(a + "===" + b + "===" + "===" + c + "===" + d);
    }
    @RequestMapping(value = "/{roomid}/news",method = RequestMethod.GET)
    public ServiceResult news(@PathVariable("roomid") String roomid){
        log.info("roomid===>"+roomid);
        return new ServiceResult();
    }

    @RequestMapping(value = "/del/news",method = RequestMethod.DELETE)
    public ServiceResult delnews(){
        log.info("roomid===>");
        return new ServiceResult();
    }


}
