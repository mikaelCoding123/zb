package com.common;

import com.mk.common.result.Result;
import com.mk.common.result.WebResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebSocketAppApplication {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketAppApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WebSocketAppApplication.class, args);
        System.out.println(Result.error().putData(""));
        System.out.println(new WebResult("nihao"));
    }

}
