package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.web.*.dao"})
public class ZMybatisLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZMybatisLearnApplication.class, args);
    }

}
