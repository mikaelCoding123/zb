package com.providerservice01;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class ProviderService01Application {

    public static void main(String[] args) {

        
        SpringApplication.run(ProviderService01Application.class, args);
    }

}
