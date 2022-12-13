package com.web.demo.service.impl;

import com.web.demo.bo.Admin;
import com.web.demo.bo.Test01;
import com.web.demo.dao.AdminDao;
import com.web.demo.dao.AdminDao2;
import com.web.demo.service.DemoService;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.StopWatch;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class DemoServiceImpl implements DemoService {
    protected final Log logger = LogFactory.getLog(this.getClass());
    @Resource
    private AdminDao adminDao;
    @Resource
    private AdminDao2 adminDao2;

    @Resource
    private TransactionTemplate transactionTemplate;

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    @Resource
    private  SqlSession sqlSession;

    /**
     * 编程式事务
     * @param id
     */
    @Override
    public void demoService(String id) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                Admin admin1 = new Admin();
                admin1.setPassword("123");
                admin1.setUsername("hua123");
                admin1.setPokid(12366L);
                adminDao.insertAdmin(admin1);
                //todo
                //会报异常待解决
                try {
//                    adminDao2.DUPLICATE(admin1);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                admin1.setPokid(1234L);
            }
        });

        Admin admin = adminDao.selectById(1L);
        System.out.println(admin);
        logger.info("11232");
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                Admin admin1 = new Admin();
                admin1.setPassword("123");
                admin1.setUsername("hua123");
                admin1.setPokid(123L);

                adminDao.insertAdmin(admin1);

                admin1.setPokid(1234L);
//                int i = 1 / 0;
            }
        });


    }

    /**
     * 采用
     * @param id
     */
    @Override
    public void demoService02(String id) {
        StopWatch stopWatch = new StopWatch("batch");
        stopWatch.start();

        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        Admin test01 = new Admin();
        ArrayList<Test01> list = new ArrayList<>();
        for (int i = 1; i < 1000; i++) {
            test01.setPokid(Long.valueOf(i+""));
            test01.setPassword(UUID.randomUUID().toString().substring(0, 8));
            test01.setUsername(UUID.randomUUID().toString().substring(0, 8));
            adminDao.insertAdmin(test01);
        }
        sqlSession.commit();
        stopWatch.stop();
        logger.info(stopWatch.prettyPrint());
    }

    /**
     * 采用batch方式插入  大量数据时容易造成内存溢出，此时可以分批插入，先插3000个
     * 根据数据库本身的特点用foreach 拼接如下sql 语句实现批处理，但是受数据库本身配置限制的sql长度大小
     * @param id
     */
    @Override
    public void demoService03(String id) {
        StopWatch stopWatch = new StopWatch("demoService03");
        stopWatch.start();
        ArrayList<Test01> test01s = new ArrayList<>();
        for (int i = 0; i < 30000; i++) {
            Test01 test01 = new Test01();
            test01.setPokid(i+"s");
            test01.setPassword(UUID.randomUUID().toString().substring(0, 8));
            test01.setUsername(UUID.randomUUID().toString().substring(0, 8));
            test01s.add(test01);
            test01=null;
        }

        adminDao.insertAdminByBatch(test01s);
        stopWatch.stop();
        logger.info(stopWatch.prettyPrint());

    }

    /**
     * 实现根据string执行xml中相对应的sql
     *
     * DATA跟xml中的id对应，hashmap则是对应的参数
     * 其中DATA必须是所有xml id 中唯一的，否则会报错
     *
     */
    @Override
    public void demoService04() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("username","1e34e7e2");
        List<Object> data = sqlSession.selectList("DATA", hashMap);
        data.forEach((a)->{
            System.out.println(a.toString());
        });
    }


    //replace into 使用有缺点
    //replace操作在自增主键的情况下，遇到唯一键冲突时执行的是delete+insert,但是在记录binlog时,却记录成了update操作,update操作不会
    //涉及到auto_increment的修改。
    //备库应用了binlog之后，备库的表的auto_increment属性不变。如果主备库发生主从切换，备库变为原来的主库，写新的主库则有风险发生主键冲突
    //频繁的REPLACE INTO 会造成新纪录的主键的值迅速增大。总有一天。达到最大值后就会因为数据太大溢出了。就没法再插入新纪录了。数据表满了，
    //不是因为空间不够了，而是因为主键的值没法再增加了。
    @PostConstruct
    public void replaceINSERT(){
        Admin admin1 = new Admin();
        admin1.setPassword("123");
        admin1.setUsername("hua123");
        admin1.setPokid(123L);
        adminDao2.replaceINTO(admin1);
    }

}
