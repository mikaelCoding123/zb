package news.service.impl;

import bean.BaseBean;
import bean.User;
import cn.hutool.core.lang.Snowflake;
import com.alibaba.dubbo.config.annotation.Reference;
import news.service.DemoService01;
import org.springframework.stereotype.Service;
import response.ServiceResult;
import service.DemoService;

import java.util.ArrayList;
import java.util.UUID;


@Service
public class DemoServiceImpl implements DemoService01 {

    @Reference(retries = 1, timeout = 7_000)
    private DemoService demoService;


    @Override
    public ServiceResult insert() {
        ServiceResult insert=null;
        BaseBean baseBean = new BaseBean();
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            User user = new User();
            long l = new Snowflake().nextId();
            user.setId(l+"");
            user.setAge(i+"");
            users.add(user);
        }
        baseBean.setObject(users);
        //insert = demoService.insert(baseBean);

        return insert;
    }
}
