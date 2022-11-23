package com.demo.web.demo.service.impl;

import com.demo.web.demo.service.CalacService;
import com.response.ServiceResult;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class Calac12ServieImpl implements CalacService {

    private BigDecimal bigDecimal = BigDecimal.TEN;

    @Override
    public boolean changeCalac(String type) {
        return "12".equals(type);
    }

    @Override
    public ServiceResult calac(Map<String, String> params) {
        ServiceResult serviceResult = new ServiceResult();
        BigDecimal  js= new BigDecimal(params.get("js"));
        BigDecimal add = js.add(new BigDecimal(12));
        serviceResult.setResultObj(add.toString());
        return serviceResult;
    }
}