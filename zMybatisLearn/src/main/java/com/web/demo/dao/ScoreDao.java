package com.web.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.web.demo.bo.StudentOfScore;
import com.web.demo.bo.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface ScoreDao extends BaseMapper<StudentOfScore> {

    List<StudentOfScore> score(HashMap hashMap);


    List<StudentOfScore> getScoreAndCId(Map hashMap);

    Page<StudentOfScore> selectList(Page<StudentOfScore> page);


    Page<StudentOfScore> selectPageVo(IPage<StudentOfScore> page, String wrapper);


    boolean insertDate(Teacher teacher);


    // 或者自定义分页类
//   MyPage selectPageVo(MyPage page);
//   // 或者返回 List
//   List<UserVo> selectPageVo(IPage<UserVo> page, Integer state);

}
