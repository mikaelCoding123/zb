package com.m267gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class M267gatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(M267gatewayApplication.class, args);
    }

}
