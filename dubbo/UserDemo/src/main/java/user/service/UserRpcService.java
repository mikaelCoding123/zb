package user.service;

import bean.User;
import com.alibaba.dubbo.config.annotation.Service;
import service.UserService;

@Service
public class UserRpcService implements UserService {
    @Override
    public User findUser(String name) {
        User user = new User();
        user.setAge("123413");
        user.setName("hua");
        user.setObject("2313");
        return user;
    }
}
