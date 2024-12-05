package com.web.demo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.demo.bo.Admin;
import com.web.demo.bo.Test01;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface AdminDao extends BaseMapper<Admin> {
//    int deleteByPrimaryKey(Long pokid);
//
//    int insert(Admin record);
//
//    int insertSelective(Admin record);
//
    Admin selectByPrimaryKey(Long pokid);
    
    int insertAdmin(Admin admin);
    int insertAdminByBatch(List<Test01> test01s);

    Admin selectAdmin(Admin admin);
//
//    int updateByPrimaryKeySelective(Admin record);
//
//    int updateByPrimaryKey(Admin record);

    List<Map> selectSc(String score);


    @Select("select * from sc where score > ${score} ")
    @ResultType(Map.class)
    List<Map> selectSc1(String score);
}