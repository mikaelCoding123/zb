package com.demo.web.pattern.service.imp;

import com.common.ServiceResult;
import com.demo.web.demo.bo.RpcBody;

public interface DemoAdapter {

    boolean type(String pid);
    ServiceResult service(String pid, RpcBody rpcBody);
}
