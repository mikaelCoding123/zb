package com.demo.web.pattern.service.imp;

import com.common.ServiceResult;
import com.demo.web.demo.bo.RpcBody;
import com.enumcode.CodeEnum;
import org.springframework.stereotype.Component;

@Component
public class Demo02ServiceImpl implements DemoAdapter {
    @Override
    public boolean type(String pid) {

        return "T".equals(pid);
    }
    @Override
    public ServiceResult service(String pid,RpcBody rpcBody) {
        return ServiceResult.success(CodeEnum.SUCCESS,"T的方式");

    }
}
