package com.esdemo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EsDemoApplication {

    public static void main(String[] args) {
//            SpringApplication.run(EsDemoApplication.class, args);
        SpringApplication app = new SpringApplication(EsDemoApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

    }

}
