package com.oj.gkuoj.dao;

import com.oj.gkuoj.entity.ProblemCategory;

import java.util.List;

public interface ProblemCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProblemCategory record);

    int insertSelective(ProblemCategory record);

    ProblemCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProblemCategory record);

    int updateByPrimaryKey(ProblemCategory record);

    List<ProblemCategory> listAll();

}