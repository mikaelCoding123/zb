package com.demo.web.config;

import com.response.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class ValidationAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ServiceResult getAdvice(MethodArgumentNotValidException e){
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        ServiceResult serviceResult = new ServiceResult();
        allErrors.forEach((error)->{
           serviceResult.setResultMsg( error.getDefaultMessage());
        });
        serviceResult.setResultCode("999999");
        serviceResult.setFlag(true);

        return serviceResult;
    }
}
