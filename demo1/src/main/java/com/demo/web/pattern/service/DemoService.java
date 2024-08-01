package com.demo.web.pattern.service;

import com.common.ServiceResult;
import com.demo.web.demo.bo.RpcBody;

public interface DemoService {
    ServiceResult service(String pid,RpcBody rpcBody);
}
