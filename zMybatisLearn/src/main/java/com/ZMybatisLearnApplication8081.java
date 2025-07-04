package com;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.web.*.dao"})
public class ZMybatisLearnApplication8081 {
    private static final Logger log = LoggerFactory.getLogger(ZMybatisLearnApplication8081.class);

    public static void main(String[] args) {
        SpringApplication.run(ZMybatisLearnApplication8081.class, args);
        log.info("启动完成。。。");
    }

}
