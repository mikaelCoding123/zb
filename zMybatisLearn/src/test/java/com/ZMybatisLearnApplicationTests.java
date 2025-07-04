package com;

import cn.hutool.core.lang.Tuple;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bean.User;
import com.enumcode.MsgEnum;
import com.web.demo.bo.Teacher;
import com.web.demo.dao.AdminDao;
import com.web.demo.dao.AdminDao3;
import com.web.demo.dao.TeacherMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ZMybatisLearnApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(ZMybatisLearnApplicationTests.class);


    @Resource
    private AdminDao adminDao;
    @Resource
    private AdminDao3 adminDao3;

    @Resource
    private TeacherMapper teacherMapper;

    @Test
    void contextLoads() {
        log.info("test===>");
        Tuple objects = new Tuple("a1", "a2");
        User user = new User();
        boolean emptyIfStr = ObjectUtil.isNull(user.getPassword());
        System.out.println(emptyIfStr);
        List<Map> maps = adminDao.selectSc("12");
        adminDao3.findByPokidList(12l);
        //expresssion为false时抛出msg内容
        Assert.isTrue(1!=0, MsgEnum.msg01.getMsg_1());

        List<Teacher> teachers = teacherMapper.selectByMap();
        teachers.forEach((a) -> {
            System.out.println(a.getBirthday());
        });
    }

    @Test
    void test01() {
        LambdaQueryWrapper<Teacher> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Teacher::getTname, "华");

        List<Teacher> teachers1 = teacherMapper.selectList(lambdaQueryWrapper);
        List<Map<String, Object>> teachers = teacherMapper.selectMaps(lambdaQueryWrapper);
        System.out.println("111");

    }



}
