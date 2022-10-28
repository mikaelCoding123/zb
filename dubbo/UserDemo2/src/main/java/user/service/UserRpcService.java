package user.service;

import bean.User;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.UserService;

@Service(retries = 3)
public class UserRpcService implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserRpcService.class);

    @Override
    public User findUser(String name) throws Exception {
        User user = new User();
        log.info("findUser......");
        user.setAge("123413");
        user.setName(name);
        user.setObject("2313");
        return user;
    }

    @Override
    public User findUsertimeout(String name) throws Exception {

        Thread.sleep(10_000);
        User user = new User();
        user.setName("timeout");
        return user;
    }

    @Override
    public User findUserRetries(String name) throws Exception {
        log.info("次数");
        Thread.sleep(10_000);
        User user = new User();
        user.setName("timeout");
        return user;
    }
}
