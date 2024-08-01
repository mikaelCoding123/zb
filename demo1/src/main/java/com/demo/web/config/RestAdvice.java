package com.demo.web.config;

import com.common.Result;
import com.common.ServiceResult;
import com.enumcode.CodeEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;

/**
 * bo验证不通过时获取的异常/统一异常捕获返回/统一返回类型
 */
@RestControllerAdvice
public class RestAdvice implements ResponseBodyAdvice<Object> {

    private static final Logger log = LoggerFactory.getLogger(RestAdvice.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ServiceResult getAdvice(MethodArgumentNotValidException e) {
        log.error(e.toString());
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        ServiceResult serviceResult = new ServiceResult();
        allErrors.forEach((error) -> {
            serviceResult.setMsg(error.getDefaultMessage());
        });
        serviceResult.setCode(CodeEnum.Exception.getCode());
        serviceResult.setFlag(true);
        return serviceResult;
    }

    //捕获自定义异常抛出异常信息
    @ExceptionHandler(RuntimeException.class)
    public ServiceResult getAdvice1(RuntimeException e) {
        e.printStackTrace();
        log.error(e.getMessage());
        return ServiceResult.setEnum(CodeEnum.Exception, e.getMessage());
    }


    //捕获异常抛出异常信息
    @ExceptionHandler({Exception.class})
    public ServiceResult getAdvice2(Exception e) {

        e.printStackTrace();
        log.error(e.getMessage());
        return ServiceResult.setEnum(CodeEnum.Exception, "");
    }

    /**
     * supports： 判断是否要交给 beforeBodyWrite 方法执行，ture：需要；false：不需要
     *
     * @param returnType
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 如果不需要进行封装的，可以添加一些校验手段，比如添加标记排除的注解
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
//        log.info("123");
        // 提供一定的灵活度，如果body已经被包装了，就不进行包装
        if (body instanceof ServiceResult) {
            return body;
        }

        if (body instanceof String) {
            try {
                return new ObjectMapper().writeValueAsString(ServiceResult.successObject(body));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        if (body instanceof com.response.ServiceResult) {
            return body;
        }

        if (body instanceof Result) {
            return body;
        }

        return ServiceResult.successObject(body);

    }
}
