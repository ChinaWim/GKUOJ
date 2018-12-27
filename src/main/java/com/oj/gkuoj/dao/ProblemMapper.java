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
     * 根据分类Id 随机返回推荐题目
     * @param proCategoryId
     * @param row
     * @return
     */
    List<Problem> listSuggestProblem(@Param("proCategoryId") Integer proCategoryId, @Param("row") int row);

    Integer countRandomProblemId();

    List<Problem> listAll(@Param("keyword")String keyword,@Param("level")Integer level,@Param("categoryId")Integer categoryId);
}