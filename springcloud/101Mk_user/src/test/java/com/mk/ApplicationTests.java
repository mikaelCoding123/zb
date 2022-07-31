package com.mk;

import com.mk.web.bo.MkUser;
import com.mk.web.dao.MkUserDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApplicationTests {

    @Resource
    private MkUserDao mkUserDao;

    @Test
    void contextLoads() {
        MkUser mkUser = new MkUser();
        mkUser.setUsername("5612");
        mkUser.setPassword("ui123");
        int i = mkUserDao.selectOne(mkUser);
        System.out.println("=====>"+i);
    }

}
