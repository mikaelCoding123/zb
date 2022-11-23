package com.demo.web.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfg extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http){
        http.antMatcher("**");
    }
}
