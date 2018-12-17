package com.oj.gkuoj.dao;

import com.oj.gkuoj.entity.CompetitionTestcaseResult;

public interface CompetitionTestcaseResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompetitionTestcaseResult record);

    int insertSelective(CompetitionTestcaseResult record);

    CompetitionTestcaseResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompetitionTestcaseResult record);

    int updateByPrimaryKey(CompetitionTestcaseResult record);
}