package com.example.demo.other;

import com.google.common.hash.BloomFilter;
import org.redisson.RedissonBloomFilter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class PutBloom  {

    @Resource(name = "nameBloom")
    private BloomFilter<String> bloomFilter;




    @PostConstruct
    public void setBloom() {
        for (int i = 0; i < 10000; i++) {
            bloomFilter.put("name:" + "zhangsan" + i);
        }
        System.out.println("put数据结束");
    }



//    @Override
//    public void afterPropertiesSet() throws Exception {
//        bloomFilter = redissonClient.getBloomFilter("demo-bloom-filter");
//        /*初始化布隆过滤器，大小1000，容错率3%*/
//        bloomFilter.tryInit(1000L, 0.03D);
//    }

}
