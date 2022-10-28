package news.service;

import bean.User;

public interface NewsService {
    User findUser(String name) throws Exception;
    User findUsertimeout(String name) throws Exception;
    User findUserRetries(String name) throws Exception;
}
