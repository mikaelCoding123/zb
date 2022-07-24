package generate;

import generate.Admin;

public interface AdminDao {
    int deleteByPrimaryKey(Long pokid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Long pokid);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}