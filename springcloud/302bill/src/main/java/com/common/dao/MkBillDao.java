package com.common.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.common.bo.MkBill;

import java.util.List;
import java.util.Map;

public interface MkBillDao extends BaseMapper<MkBill> {
    int deleteByPrimaryKey(String billId);

    int insert(MkBill record);

    int insertSelective(MkBill record);

    MkBill selectByPrimaryKey(String billId);

    int updateByPrimaryKeySelective(MkBill record);

    int updateByPrimaryKey(MkBill record);

    List<Map<String, String>> selectBills(String userid);
}