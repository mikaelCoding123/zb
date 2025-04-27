package com.web.demo.action;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.common.ServiceResult;
import com.web.demo.bo.StudentOfScore;
import com.web.demo.dao.ScoreDao;
import com.web.demo.service.PlusService;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
public class MyBatisPlusAction {

    @Resource
    private PlusService plusService;

    @Resource
    private ScoreDao scoreDao;

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
        Page<StudentOfScore> studentOfScores = scoreDao.selectPageVo(studentOfScorePage,  "wrapper");

        return ServiceResult.successObject(studentOfScores);
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
    }

}
