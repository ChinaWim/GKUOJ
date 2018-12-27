package com.oj.gkuoj.dao;

import com.oj.gkuoj.entity.ProblemResult;

public interface ProblemResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProblemResult record);

    int insertSelective(ProblemResult record);

    ProblemResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProblemResult record);

    int updateByPrimaryKey(ProblemResult record);

}