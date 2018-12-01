package com.oj.gkuoj.dao;

import com.oj.gkuoj.entity.ProblemCategory;

public interface ProblemCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProblemCategory record);

    int insertSelective(ProblemCategory record);

    ProblemCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProblemCategory record);

    int updateByPrimaryKey(ProblemCategory record);
}