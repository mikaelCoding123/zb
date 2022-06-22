package com.demo.web.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DemoDao {
    @Select("select * from admin where pokid=#{id}")
    Map<String, String> getDemoById(@Param("id") String id);

    List<Map<String, String>> getDemoByName(@Param("username") String username);

}
