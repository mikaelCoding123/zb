package com;


import com.common.CodeEnum;
import com.common.MsgEnum;
import com.common.ServiceResult;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.web.*.dao"})
public class ZMybatisLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZMybatisLearnApplication.class, args);
        System.out.println(MsgEnum.SUCCESS.getMsg_1());
    }

}
