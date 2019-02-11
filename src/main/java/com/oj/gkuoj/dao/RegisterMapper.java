package com.oj.gkuoj.dao;

import com.oj.gkuoj.entity.Register;
import org.apache.ibatis.annotations.Param;

public interface RegisterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Register record);

    int insertSelective(Register record);

    Register selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);

    Register getByUserIdAndCompId(@Param("userId") Integer userId,@Param("compId") Integer compId);

    int countByUserIdAndCompId(@Param("userId") Integer userId,@Param("compId") Integer compId);

}