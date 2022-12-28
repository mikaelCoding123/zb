package com.demo.web;

import com.common.MsgEnum;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
@MapperScan({"com.demo.web.*.dao"})
public class Demo1Application {


    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
        System.out.println(MsgEnum.msg01.getMsg_1());
        System.out.println("=====>启动完成");

    }

}
