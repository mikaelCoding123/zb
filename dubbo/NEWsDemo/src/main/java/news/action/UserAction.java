package news.action;

import bean.User;
import news.service.NewsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import response.ServiceResult;

import javax.annotation.Resource;

@RequestMapping
@RestController
public class UserAction {

    @Resource
    private NewsService newsService;

    //dubbo调用userdemo服务
    @RequestMapping("/news")
    public ServiceResult getUser() throws Exception {
        User hfjks = newsService.findUser("hfjks");
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setData(hfjks);

        return serviceResult;
    }

    //dubbo调用userdemo服务
    @RequestMapping("/news/timeout")
    public ServiceResult getTimeout() throws Exception {
        User hfjks = newsService.findUsertimeout("hfjks");
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setData(hfjks);

        return serviceResult;
    }
    //retries 重试 只有在多个注册中才能生效
    @RequestMapping("/news/retries")
    public ServiceResult getRetries() throws Exception {
        User hfjks = newsService.findUserRetries("hfjks");
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setData(hfjks);
        return serviceResult;
    }


    //传递user给userdemo服务
    @RequestMapping("/news/user")
    public ServiceResult toUser(){
        User user = new User();
        user.setName("news==hua");
        User user1 = newsService.toUserdemo( user);
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setData(user1);
        return serviceResult;

    }

}
