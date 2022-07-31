package generate;

import generate.MkUser;

public interface MkUserDao {
    int deleteByPrimaryKey(String userid);

    int insert(MkUser record);

    int insertSelective(MkUser record);

    MkUser selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(MkUser record);

    int updateByPrimaryKey(MkUser record);
}