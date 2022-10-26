package news.action;

import bean.User;
import news.service.NewsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import response.ServiceResult;
import service.UserService;

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
        serviceResult.setResultObj(hfjks);

        return serviceResult;
    }

    //dubbo调用userdemo服务
    @RequestMapping("/news/timeout")
    public ServiceResult getTimeout() throws Exception {
        User hfjks = newsService.findUser("hfjks");
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultObj(hfjks);

        return serviceResult;
    }


}
