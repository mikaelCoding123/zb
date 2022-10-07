package com.m256gateway.filter.Ip;


import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IPDao {
    @Select("select * from gateway ")
    List<Map<String,String>> getIP();

}
