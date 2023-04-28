package com.demo.web.mushiweb;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

}
