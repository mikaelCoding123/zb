package com.web.demo.action;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.common.ServiceResult;
import com.web.demo.bo.StudentOfScore;
import com.web.demo.bo.Teacher;
import com.web.demo.dao.ScoreDao;
import com.web.demo.service.PlusService;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


////https://www.toutiao.com/article/7498627321314673193/?log_from=d715aeb1a7e928_1747080223985&from_pwa=1
@RestController
@CrossOrigin
public class MyBatisPlusAction {

    @Resource
    private PlusService plusService;

    @Resource
    private ScoreDao scoreDao;

    @Resource
    private com.web.demo.dao.teacherMapper teacherMapper;

    @RequestMapping(value = "/plus", method = RequestMethod.GET)
    public ServiceResult plusAction() {
        ServiceResult serviceResult = plusService.insertAdmin();
        System.out.println(DigestUtils.md5DigestAsHex("key".toString().getBytes()));
        return serviceResult;
    }

    @RequestMapping(value = "/plus2", method = RequestMethod.GET)
    public ServiceResult plusAction2() {
//        ServiceResult serviceResult = plusService.insertAdmin();
        System.out.println(DigestUtils.md5DigestAsHex("key".toString().getBytes()));
        return null;
    }

    //
    @RequestMapping(value = "/score", method = RequestMethod.GET)
    public ServiceResult getScore() {

        //条件
        HashMap<String, String> map = new HashMap<>();
        map.put("cld", "02");
        List<StudentOfScore> score = scoreDao.score(map);

        List<StudentOfScore> scoreAndCId = scoreDao.getScoreAndCId(map);

        return ServiceResult.successObject(scoreAndCId);
    }

    //分页
    @RequestMapping("/scorePage/{pageNumber}/{pageSize}")
    public ServiceResult paginationTest(@PathVariable("pageNumber") String pageNumber, @PathVariable("pageSize") String pageSize) {

        Page<StudentOfScore> studentOfScorePage = new Page<>(Integer.valueOf(pageNumber), Integer.valueOf(pageSize));
        //wrapper 为条件参数
        //https://blog.csdn.net/Sayatnoon/article/details/136175384
        Page<StudentOfScore> studentOfScores = scoreDao.selectPageVo(studentOfScorePage, "wrapper");

        return ServiceResult.successObject(studentOfScores);
    }

    //时间类型的
    @RequestMapping(value = "/insterDate", method = RequestMethod.GET)
    public ServiceResult insterDate() {

        String date = "1993-09-07 12:12:12";
        LocalDateTime parse = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime parse1 = LocalDateTimeUtil.parse(date);


        Teacher teacher = new Teacher();
        teacher.setBirthday(parse);
        teacher.setTid(ThreadLocalRandom.current().nextInt(1000) + "");
        teacher.setTname(ThreadLocalRandom.current().nextInt(1000) + "");
        System.out.println(teacher);
        //插入时间
        int b = teacherMapper.insert(teacher);
        return ServiceResult.defaultSuccess();
    }
    //分页
    //mybatisPlus 单表的多个条件
    @RequestMapping(value = "/more", method = RequestMethod.GET)
    public ServiceResult moreWrapper() {

        Page<Teacher> teacherPage = new Page<>(3, 5);
        LambdaQueryWrapper<Teacher> lambdaQueryWrapper = new LambdaQueryWrapper<Teacher>();
        lambdaQueryWrapper.eq(Teacher::getTid, "12");


        IPage<Teacher> teacherPage1 = teacherMapper.selectPage(teacherPage, lambdaQueryWrapper);

        return ServiceResult.successObject(teacherPage1);
    }

    //单表的insert
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public ServiceResult insert01(@RequestParam("id") String id) {

        Teacher teacher = new Teacher(id, "xiang", LocalDateTime.parse("2021-12-03 12:34:31", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        //insert 成功时返回1
        teacher.setTid("" + Instant.now().toEpochMilli());
        int insert = teacherMapper.insert(teacher);
        //update 成功时返回1
        teacher.setTid(id);
        //用ById时 要在teacher里添加@TableId指定属性为id
        int i = teacherMapper.updateById(teacher);

        //
        System.out.println("===============");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tid", "1747099270417");

        List<Teacher> teachers = teacherMapper.selectByMap(map);
        return ServiceResult.successObject(insert);
    }

    //单表的update
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ServiceResult update01() {

        Teacher teacher = new Teacher();
        teacher.setTid("1747099270417");
        teacher.setTname("张明");

        int i = teacherMapper.updateById(teacher);
        List<Map<String, Teacher>> teachers = teacherMapper.selectList("1993-12-12 12:00:00", "2000-12-12 12:00:00");
        List<Map<String, Teacher>> mapList = teacherMapper.selectLike("明");
        return i > 0 ? ServiceResult.successObject(teachers.addAll(mapList)) : ServiceResult.defaultError();
    }


    public static void main(String[] args) {
//        System.out.println(new String(DigestUtil.sha256Hex("hua")));
//        System.out.println(DigestUtil.bcrypt("110"));
//        System.out.println(DigestUtil.bcryptCheck("110", "$2a$10$egemTwPgFZZhczT23IACkeptfAdUSSZXZTPIQ7VKqF8PyP5hqYnuu"));
//        ServiceResult serviceResult = JSON.parseObject("{\n" +
//                "  \"code\": \"99999\",\n" +
//                "  \"msg\": \"系统错误\",\n" +
//                "  \"data\": null,\n" +
//                "  \"flag\": true\n" +
//                "}", ServiceResult.class);
//        System.out.println(serviceResult);


        /**
         * 时间
         */
        //输出格式：1745917487708
        System.out.println(Instant.now().toEpochMilli());

        //输出格式：2025-04-29T17:02:55.875
        System.out.println(LocalDateTimeUtil.of(Instant.now()));
        System.out.println(LocalDate.now());
        //输出格式: 1746125965949
        System.out.println(new Date().getTime());
        //yyyy-MM-dd HH:mm:ss
        System.out.println(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date().getTime()));
        //
        System.out.println(new SimpleDateFormat("yyyy-mm-dd HH:MM:SS").format(Instant.now().toEpochMilli()));


        long maxValue = Instant.now().toEpochMilli();
        long i = 13065975433L + 12341234l * 4;
        System.out.println(i);
    }

}
