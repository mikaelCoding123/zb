package user.service;

import bean.User;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.UserService;

@Service
public class UserRpcService implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserRpcService.class);
    @Override
    public User findUser(String name) throws Exception {
        User user = new User();
        log.info("findUser......");
        int i=1/0;

        user.setAge("123413");
        user.setName(name);
        user.setObject("2313");
        return user;
    }
}
