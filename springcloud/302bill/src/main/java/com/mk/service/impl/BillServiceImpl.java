package com.mk.service.impl;

import com.mk.bo.MkBill;
import com.mk.dao.MkBillDao;
import com.mk.service.BillService;
import com.response.ServiceResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("BillServiceImpl")
public class BillServiceImpl implements BillService {
    @Resource
    private MkBillDao mkBillDao;

    @Override
    public ServiceResult queryBill(String userid) {
        List<Map<String, String>> maps = mkBillDao.selectBills(userid);
        return new ServiceResult().putObject(maps);
    }
}
