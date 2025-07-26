package com;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.web.demo.bo.Goods;
import com.web.demo.dao.GoodsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author
 * @version 1.0
 * @date 2025/7/4
 */

@SpringBootTest
public class Test01 {

    @Resource
    private GoodsMapper goodsMapper;

    @Test
    void test01() {
        System.out.println("1111");
    }


    //
    @Test
    void test02(){
        UpdateWrapper<Goods> updateWrapper = new UpdateWrapper<>();

        updateWrapper.eq("id", "euisk12"  ).gt("number", 0).setSql(true,"number=number-"+1);

        goodsMapper.update(null,updateWrapper);
        updateWrapper.clear();
        updateWrapper.setSql("number = number+1,flag=3").eq("id", "euisk12");
        goodsMapper.update(null,updateWrapper);

    }

}
