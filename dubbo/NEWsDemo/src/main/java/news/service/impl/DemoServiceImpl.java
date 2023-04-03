package news.service.impl;

import bean.BaseBean;
import bean.User;
import cn.hutool.core.lang.Snowflake;
import com.alibaba.dubbo.config.annotation.Reference;
import news.service.DemoService01;
import org.springframework.stereotype.Service;
import response.ServiceResult;
import service.DemoService;

import java.util.UUID;


@Service
public class DemoServiceImpl implements DemoService01 {

    @Reference(retries = 1, timeout = 7_000)
    private DemoService demoService;


    @Override
    public ServiceResult insert() {
        ServiceResult insert=null;
        for (int i = 0; i < 1000; i++) {
            BaseBean baseBean = new BaseBean();
            User user = new User();
            long l = new Snowflake().nextId();
            user.setId(l+"");
            user.setAge(i+"");
            baseBean.setMethod(""+i);
            baseBean.setObject(user);
            insert = demoService.insert(baseBean);
        }

        return insert;
    }
}
