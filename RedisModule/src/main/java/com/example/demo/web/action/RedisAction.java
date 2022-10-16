package com.example.demo.web.action;

import com.bean.User;
import com.google.gson.Gson;
import com.response.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("redis")
public class RedisAction {
    private static final Logger log = LoggerFactory.getLogger(RedisAction.class);
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private Gson gson;

    /**
     * 普通的string使用
     */
    @GetMapping("test01")
    public ServiceResult test01() {
        log.info("===>" + redisTemplate.opsForValue().get("name").toString());
        redisTemplate.opsForValue().set("name", "画12", 10_000l, TimeUnit.SECONDS);
        log.info(redisTemplate.opsForValue().get("name").toString());
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.putMsg("88799");
        return serviceResult;
    }

    @GetMapping("test02")
    public void test02() {
        User user = new User();
        user.setUsername("lisi");
        user.setPokid("eiuhls");
        user.setPassword("uikjfks");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("user", user);
        redisTemplate.opsForHash().putAll("user", hashMap);
        redisTemplate.expire("user", Duration.ofSeconds(20));//设置key的过期时间
        User o = (User) redisTemplate.opsForHash().entries("user").get("user");
        log.info(o.toString());
    }

    /**
     * jmeter 大量测试
     *
     * @param id
     */
    @GetMapping("/jmeter/{id}")
    public void test02(@PathVariable("id") String id) {
        redisTemplate.opsForValue().set("id==>" + id, id);
        log.info("id======>" + id);
    }

    @PostMapping("/jmeter/id")
    public void test02(@RequestBody Map<String, Object> paramsMap) {
        log.info(paramsMap.get("name").toString());
    }


}
