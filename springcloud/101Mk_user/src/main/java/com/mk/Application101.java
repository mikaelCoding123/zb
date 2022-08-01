package com.mk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@MapperScan(basePackages = {"com.mk.*.dao"}) //不能将service层的接口也包含在内，必须将范围缩小到dao包的位置
public class Application101 {

    public static void main(String[] args) {
        SpringApplication.run(Application101.class, args);
    }

}
