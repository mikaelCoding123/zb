package com.web.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.demo.bo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
* @author hua
* @description 针对表【admin】的数据库操作Mapper
* @createDate 2023-01-02 00:22:37
* @Entity generator.domain.Admin
*/
@Mapper
public interface AdminDao3 extends BaseMapper<Admin> {

    int deleteByPrimaryKey(Long id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    @Select("Select * from  admin where pokid=${id}")
    Admin findByPokidList(long id);
}
