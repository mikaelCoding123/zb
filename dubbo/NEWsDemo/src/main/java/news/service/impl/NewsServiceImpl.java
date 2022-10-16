package news.service.impl;

import bean.User;
import com.alibaba.dubbo.config.annotation.Reference;
import news.service.NewsService;
import org.springframework.stereotype.Service;
import service.UserService;

@Service
public class NewsServiceImpl implements NewsService {

    @Reference(url = "${dubbourl}")
    private UserService userService;

    @Override
    public User findUser(String name) {
        User user = userService.findUser(name);
        return user;
    }
}
