package com.demo.web.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DemoDao  {

    @Select("select * from admin where pokid=#{id}")
    Map<String, String> getDemoById(@Param("id") String id);

    List<Map<String, String>> getDemoByName(@Param("username") String username);

    @Insert("insert into admin (pokid,username, password) values(#{pokid},#{username},#{password}) ")
    int setAdmin(Map<String, String> paramsMap);

    @Insert("insert into ip_address(pokid,ip,datetime,date,date_time) values(#{pokid}, )")
    int insertIP(Map<String, String> paramsMap);

    int insetDemo(Map<String,Object> paramsMap);
    List<Map<String,Object>> selectIP();
    int insertlogs(@Param("id") String uuid , @Param("user")String user);

    @Select("SELECT * from codeenum")
    List<Map<String,String>> selectCodeEnum();

    @Insert("INSERT INTO `test02` VALUES (#{uuid}, 'a', 'fksl', 'h', 'h', 'o', 'l', 'o', 'u', 'i', 'i', 'o')")
    boolean insertTest02(@Param("uuid") String uuid);


    @Select("select * from admin ")
    List<Map<String,String>> selectAdmin();

}
