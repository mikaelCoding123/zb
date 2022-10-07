package com.m256gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.*.*.Ip")
public class M256gatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(M256gatewayApplication.class, args);
    }

}
