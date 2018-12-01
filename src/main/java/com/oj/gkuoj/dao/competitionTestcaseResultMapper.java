package com.oj.gkuoj.dao;

import com.oj.gkuoj.entity.competitionTestcaseResult;

public interface competitionTestcaseResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(competitionTestcaseResult record);

    int insertSelective(competitionTestcaseResult record);

    competitionTestcaseResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(competitionTestcaseResult record);

    int updateByPrimaryKey(competitionTestcaseResult record);
}