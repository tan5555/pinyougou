package com.kgc.pinyougou.mapper;

import com.kgc.pinyougou.domain.User;
import com.kgc.pinyougou.domain.UserExample;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}