package generator.mapper;

import generator.domain.user;

/**
 * @author hua
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2024-10-27 04:09:17
 * @Entity generator.domain.user
 */
public interface userMapper {

    int deleteByPrimaryKey(Long id);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);

}
