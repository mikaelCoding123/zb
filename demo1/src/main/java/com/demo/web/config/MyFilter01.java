package com.demo.web.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 不管什么请求过来都会被过滤，只要ip跟端口对就行哪怕是错误的url
 */
@Component
public class MyFilter01 extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("=======");
        /**
         * 这里可以进行过滤包括重定向
         * 跳过登录、注册一些不用登录的接口
         * 进行jwt在校验，黑名单的校验（jwt中存着部分用户信息，将jwt解析出来进行黑名单过滤）用户信息中有表示是否为黑名单的字段
         * filterChain表示进入下一个过滤器
         */
        if("aaa".equals(request.getHeader("head")) ){
            return;
        }
        filterChain.doFilter(request, response);
    }
}
