package com.bean.interfaces;

import com.bean.response.ServiceResult;

public interface Order {
    ServiceResult getOrder(String userid);
}
