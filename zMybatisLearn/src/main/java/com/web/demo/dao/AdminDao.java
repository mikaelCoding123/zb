package com.web.demo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.demo.bo.Admin;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface AdminDao extends BaseMapper<Admin> {
    int deleteByPrimaryKey(Long pokid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Long pokid);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}