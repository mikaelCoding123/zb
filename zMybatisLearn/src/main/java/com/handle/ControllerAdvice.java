package com.handle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Component
public class ControllerAdvice {
    @ResponseStatus(code = HttpStatus.BAD_GATEWAY, reason = "找不到服务")
    @ExceptionHandler(Exception.class)
    public Exception handleException(Exception e) {
        log.error(e.getMessage());
        return e;

    }

}
