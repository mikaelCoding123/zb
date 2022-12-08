package com.demo.web.config;

import com.exception.ServiceException;
import com.response.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 验证不通过时获取的异常
 */
@RestControllerAdvice
public class ValidationAdvice {

    private static final Logger log = LoggerFactory.getLogger(ValidationAdvice.class);

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
    //捕获自定义异常抛出异常信息
    @ExceptionHandler(RuntimeException.class)
    public ServiceResult getAdvice1(RuntimeException e){
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultMsg(e.getMessage());
        serviceResult.setResultCode("999999");
        return serviceResult;
    }

    //捕获异常抛出异常信息
    @ExceptionHandler({Exception.class})
    public ServiceResult getAdvice2(Exception e){
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultMsg("系统问题："+e.getMessage());
        serviceResult.setResultCode("888888");
        return serviceResult;
    }

}
