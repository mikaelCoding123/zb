package com.response;

import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public enum ResponEnum {


//HttpStatus http状态码
    success(200, "成功"),
    fail(500, "失败"),;


    public final int code;
    private final String msg;

    private ResponEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    @Override
    public String toString() {
        return this.code+"";
    }
    public static void main(String[] args) {
        System.out.println(ResponEnum.success);
        System.out.println(HttpStatus.ACCEPTED.toString());//202 ACCEPTED
        System.out.println(HttpStatus.ACCEPTED.value());//202
        System.out.println(HttpStatus.ACCEPTED.name());//ACCEPTED
    }
}


