package com.oj.gkuoj.dao;

import com.oj.gkuoj.entity.UserRole;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    int deleteByUserId(Integer userId);
}