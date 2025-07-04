package com.web.demo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.demo.bo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author hua
 * @description 针对表【teacher】的数据库操作Mapper
 * @createDate 2025-04-29 16:10:24
 * @Entity com.web.demo.bo.Teacher.teacher
 */
@Component
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

    List<Map<String, Teacher>> selectList1(String startime, String endtime);

    List<Map<String, Teacher>> selectLike1(String name);

    List<Teacher> selectByMap();
}




