package news.service.impl;

import bean.User;
import com.alibaba.dubbo.config.annotation.Reference;
import news.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import service.UserService;

@Service
public class NewsServiceImpl implements NewsService {

    private static final Logger log = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Reference(retries = 3,timeout = 7_000)
    private UserService userService;

    @Override
    public User findUser(String name) throws Exception {
        log.info("次数");
        User user = userService.findUser(name);
        return user;
    }

    @Override
    public User findUsertimeout(String name) throws Exception {
        User user = userService.findUsertimeout(name);
        log.info(user.toString());
        return user;
    }

    @Override
    public User findUserRetries(String name) throws Exception {
        log.info("次数");
        User userException = userService.findUserRetries(name);
        return userException;
    }

    public String nocall() {
        log.info("findUser失败。。。。的fallbackMethod");
        return "";
    }
}
