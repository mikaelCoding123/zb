package com.demo.web.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfg extends WebSecurityConfigurerAdapter {

    /**
     * http请求设置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("**")
                .permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                // 其他需要拦截
                .authenticated();
    }
}
