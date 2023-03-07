package user.service;

import bean.BaseBean;
import bean.User;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import response.ServiceResult;
import service.DemoService;

@Service()
public class DemoRpcService implements DemoService {

    private static final Logger log = LoggerFactory.getLogger(DemoRpcService.class);
    @Override
    public ServiceResult insert(BaseBean baseBean) {

        //策略模式实现

        log.info("insert........."+baseBean.getMethod());
        return ServiceResult.defaultSuccess();
    }
}
