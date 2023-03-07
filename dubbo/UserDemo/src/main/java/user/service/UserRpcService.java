package user.service;

import bean.User;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import service.UserService;

@Service(retries = 3)
public class UserRpcService implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserRpcService.class);
    @Value("${server.port}")
    private String port;

    @Override
    public User findUser(String name) throws Exception {
        User user = new User();
        log.info("findUser......userdemo服务");
        user.setAge("123413");
        user.setName(name);
        user.setObject("port===>"+port);
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

    @Override
    public User findUserRet(User user) {
        log.info(user.toString());
        try {
            int i= 1/0;

        }catch (Exception e){
            throw new RpcException();
        }

        user.setName("userdemo====>hua");
        return user;
    }
}
