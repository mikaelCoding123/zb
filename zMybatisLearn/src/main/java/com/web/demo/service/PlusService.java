package com.web.demo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.common.ServiceResult;
import com.web.demo.bo.Admin;

public interface PlusService {
    ServiceResult insertAdmin();

    ServiceResult AdminMapper01();

    int update();

}
