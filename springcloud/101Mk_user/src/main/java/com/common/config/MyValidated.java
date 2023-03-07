package com.common.config;

import com.response.ServiceResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 参数校验
 */
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
