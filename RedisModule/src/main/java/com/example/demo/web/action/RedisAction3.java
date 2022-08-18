package com.example.demo.web.action;


import com.example.demo.web.service.RedisService;
import com.google.common.hash.BloomFilter;
import com.response.ServiceResult;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 布隆过滤器的使用
 *
 *
 */
@RestController
@RequestMapping("bf")
public class RedisAction3 {

    @Resource(name = "RedisService01Impl")
    private RedisService redisService;


    @Resource(name = "nameBloom")
    private BloomFilter<String> nameBloomFilter;

    @Resource(name = "redissonClient")
    private RedissonClient redissonClient;

    @RequestMapping("api/redis/test01")
    public ServiceResult getway01() {

        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultMsg("api/test01");
        return serviceResult;
    }

    @RequestMapping(value = "api/redis/test02/{id}", method = RequestMethod.GET)
    public ServiceResult getway02(@PathVariable("id")String id) {
        RBloomFilter<String> bloomFilter = redissonClient.getBloomFilter("bloom-filter");
        //初始化，容量1000，错误率千分之三
        bloomFilter.tryInit(1000, 0.003);
        //add1000个
        for (int i = 0; i < 1000; i++) {
            bloomFilter.add("tom " + i);
        }
        int count = 0;
        //查询1000次
        for (int i = 0; i < 1000; i++) {
            if (bloomFilter.contains("bob" + i)) {
                count++;
            }
        }
        System.out.println("错误个数=" + count);
        System.out.println("预计插入数量：" + bloomFilter.getExpectedInsertions());
        System.out.println("容错率：" + bloomFilter.getFalseProbability());
        System.out.println("hash函数的个数：" + bloomFilter.getHashIterations());
        System.out.println("插入对象的个数：" + bloomFilter.count());
        ServiceResult serviceResult = new ServiceResult();
        return serviceResult.putMsg("");
    }

    @RequestMapping(value = "api/redis/test03", method = RequestMethod.GET)
    public ServiceResult getway03() {


        return redisService.getRedis();
    }


}
