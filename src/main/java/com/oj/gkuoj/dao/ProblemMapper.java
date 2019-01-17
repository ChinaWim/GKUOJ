package com.oj.gkuoj.dao;

import com.oj.gkuoj.entity.Problem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProblemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Problem record);

    int insertSelective(Problem record);

    Problem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Problem record);

    int updateByPrimaryKey(Problem record);

    /**
     * 根据题目Id 随机返回推荐题目
     * @param problemId
     * @param row
     * @return
     */
    List<Problem> listSuggestProblem(@Param("problemId") Integer problemId, @Param("row") int row);

    Integer countRandomProblemId();

    List<Problem> listAll(@Param("keyword") String keyword, @Param("level") Integer level, @Param("tagName") String tagName);
}