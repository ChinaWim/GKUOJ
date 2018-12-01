package com.oj.gkuoj.dao;

import com.oj.gkuoj.entity.CompetitionResult;

public interface CompetitionResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompetitionResult record);

    int insertSelective(CompetitionResult record);

    CompetitionResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompetitionResult record);

    int updateByPrimaryKey(CompetitionResult record);
}