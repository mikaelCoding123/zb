package com.web.demo.service.impl;

import com.web.demo.bo.Admin;
import com.web.demo.bo.Test01;
import com.web.demo.dao.AdminDao;
import com.web.demo.dao.AdminDao2;
import com.web.demo.service.DemoService;
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

import javax.annotation.Resource;
import java.util.*;

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
                admin1.setPokid(12366l);
                adminDao.insertAdmin(admin1);
                //todo
                //会报异常待解决
                adminDao2.DUPLICATE(admin1);
                admin1.setPokid(1234l);
            }
        });

        Admin admin = adminDao.selectById(1L);
        System.out.println(admin);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                Admin admin1 = new Admin();
                admin1.setPassword("123");
                admin1.setUsername("hua123");
                admin1.setPokid(123l);
                adminDao.insertAdmin(admin1);

                admin1.setPokid(1234l);
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
}
