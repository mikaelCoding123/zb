package com.demo.web.pattern.service.imp;

import com.common.ServiceResult;
import com.demo.web.demo.bo.RpcBody;
import org.springframework.stereotype.Component;

@Component
public class Demo01ServiceImpl implements DemoAdapter {

    @Override
    public boolean type(String pid) {

        return "C".equals(pid);
    }

    @Override
    public ServiceResult service(String pid,RpcBody rpcBody) {
        return ServiceResult.successObject("C的方式");
    }
}
