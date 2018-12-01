package com.oj.gkuoj.dao;

import com.oj.gkuoj.entity.TestcaseResult;

public interface TestcaseResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestcaseResult record);

    int insertSelective(TestcaseResult record);

    TestcaseResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestcaseResult record);

    int updateByPrimaryKey(TestcaseResult record);
}