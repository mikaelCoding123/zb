package news.action;

import news.service.DemoService01;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import response.ServiceResult;
import service.DemoService;

import javax.annotation.Resource;

@RestController
public class DemoAction {

    @Resource
    private DemoService01 demoService01;

    @RequestMapping(value = "demo/insert",method = RequestMethod.GET)
    public ServiceResult insert(){
        ServiceResult insert = demoService01.insert();
        return insert;
    }


}
