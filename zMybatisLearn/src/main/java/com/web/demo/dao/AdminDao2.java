package com.web.demo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.demo.bo.Admin;
import com.web.demo.bo.Test01;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminDao2 extends BaseMapper<Admin> {
//    int deleteByPrimaryKey(Long pokid);
//
//    int insert(Admin record);
//
//    int insertSelective(Admin record);
//
    Admin selectByPrimaryKey(Long pokid);
    int insertAdmin(Admin admin);
    int insertAdminByBatch(List<Test01> test01s);


    void DUPLICATE(Admin admin);
//
//    int updateByPrimaryKeySelective(Admin record);
//
//    int updateByPrimaryKey(Admin record);

    void replaceINTO(Admin admin);

}