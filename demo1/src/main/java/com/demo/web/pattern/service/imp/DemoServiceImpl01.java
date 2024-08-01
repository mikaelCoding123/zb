package com.demo.web.pattern.service.imp;

import com.common.ServiceResult;
import com.demo.web.demo.bo.RpcBody;
import com.demo.web.pattern.service.DemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("DemoServiceImpl01")
public class DemoServiceImpl01 implements DemoService {
    @Resource
    private List<DemoAdapter> demoAdapterList;

    @Override
    public ServiceResult service(String pid, RpcBody rpcBody) {
        for (DemoAdapter demoAdapter : demoAdapterList) {
            if (demoAdapter.type(pid)) {
                return demoAdapter.service(pid, rpcBody);
            }
        }
        return ServiceResult.defaultError();
    }
}
