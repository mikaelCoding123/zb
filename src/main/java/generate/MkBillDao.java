package generate;

import generate.MkBill;

public interface MkBillDao {
    int deleteByPrimaryKey(String billId);

    int insert(MkBill record);

    int insertSelective(MkBill record);

    MkBill selectByPrimaryKey(String billId);

    int updateByPrimaryKeySelective(MkBill record);

    int updateByPrimaryKey(MkBill record);
}