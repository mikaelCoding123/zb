package generate;

import generate.Wl;

public interface WlDao {
    int deleteByPrimaryKey(String id);

    int insert(Wl record);

    int insertSelective(Wl record);

    Wl selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Wl record);

    int updateByPrimaryKey(Wl record);
}