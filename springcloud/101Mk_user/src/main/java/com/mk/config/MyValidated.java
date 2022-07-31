package com.mk.config;

import com.response.ServiceResult;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Component
@RestControllerAdvice
public class MyValidated {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ServiceResult getValidated(MethodArgumentNotValidException e){
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        ServiceResult serviceResult = new ServiceResult();
        allErrors.forEach((error)->{
            serviceResult.putMsg(error.getDefaultMessage());
            serviceResult.putCode("999999");
        });
        return serviceResult;
    }
}
