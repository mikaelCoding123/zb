package com.example.demo.web.action;

import com.response.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Set;

@RestController
@RequestMapping("/Phb")
public class PhbAction {

    private static final Logger log = LoggerFactory.getLogger(PhbAction.class);

    @Resource
    private RedisTemplate redisTemplate;


    @RequestMapping("/hqPhb")
    public ServiceResult hqPhb() {
        ServiceResult serviceResult = new ServiceResult();
        redisTemplate.opsForZSet().add("shangjia", "li", 0);
        redisTemplate.opsForZSet().add("shangjia", "zhang", 0);
        redisTemplate.opsForZSet().add("shangjia", "mu", 0);
        redisTemplate.opsForZSet().add("shangjia", "hu", 0);
        //买了一次就加上-1
        redisTemplate.opsForZSet().incrementScore("shangjia", "li", -1);
        redisTemplate.opsForZSet().incrementScore("shangjia", "zhang", -1);
        redisTemplate.opsForZSet().incrementScore("shangjia", "mu", -1);
        //买了200次就加-1 200次
        for (int i = 0; i < 200; i++) {
            redisTemplate.opsForZSet().incrementScore("shangjia", "hu", -1);
        }

        Set shangjia = redisTemplate.opsForZSet().range("shangjia", 0, 100);
        ArrayList<Object> objects = new ArrayList<>();

        serviceResult.setResultObj(shangjia);
        log.info("==========");
        return serviceResult;
    }


}
