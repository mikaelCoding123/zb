package com.web.demo.action;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.common.ServiceResult;
import com.web.demo.bo.StudentOfScore;
import com.web.demo.bo.Teacher;
import com.web.demo.dao.ScoreDao;
import com.web.demo.service.PlusService;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
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

    //


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

        System.out.println();
    }

}
