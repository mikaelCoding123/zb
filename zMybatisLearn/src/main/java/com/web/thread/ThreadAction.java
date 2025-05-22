package com.web.thread;

import com.common.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/thread")
public class ThreadAction {

    private static final Logger log = LoggerFactory.getLogger(ThreadAction.class);

    @RequestMapping(value = "/test01",method = RequestMethod.GET)
    public ServiceResult test01(){
        Assert.isTrue(true, "");
        new Thread(()->{
            try {
                Thread.sleep(5_000);
                throw new Exception("异常！！！！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"test01").start();

        return ServiceResult.defaultSuccess();
    }

}
