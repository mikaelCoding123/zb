package service;

import bean.User;

public interface UserService {
    public User findUser(String name) throws Exception;
    public User findUsertimeout(String name)throws  Exception;
    public User findUserRetries(String name) throws Exception;
    public User findUserRet(User user);
}
