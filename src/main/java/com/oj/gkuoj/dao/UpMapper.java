package com.oj.gkuoj.dao;

import com.oj.gkuoj.entity.Up;

public interface UpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Up record);

    int insertSelective(Up record);

    Up selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Up record);

    int updateByPrimaryKey(Up record);
}