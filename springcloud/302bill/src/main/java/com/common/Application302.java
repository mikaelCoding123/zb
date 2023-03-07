package com.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@MapperScan(basePackages = {"com.mk.dao"})
public class Application302 {

    public static void main(String[] args) {
        SpringApplication.run(Application302.class, args);
    }

}
