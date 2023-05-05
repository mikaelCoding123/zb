package com.common.service.impl;

import com.common.dao.MkBillDao;
import com.common.service.BillService;
import com.response.ServiceResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
