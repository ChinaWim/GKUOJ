package com.oj.gkuoj.dao;

import com.oj.gkuoj.entity.Competition;
import com.oj.gkuoj.response.CompetitionDetailVO;
import com.oj.gkuoj.response.CompetitionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompetitionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Competition record);

    int insertSelective(Competition record);

    Competition selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Competition record);

    int updateByPrimaryKey(Competition record);

    CompetitionDetailVO getCompetitionDetailVOById(Integer compId);

    List<CompetitionVO> listCompetitionVO(@Param("keyword") String keyword);

    List<CompetitionDetailVO> listLastCompetitionDetailVO(Integer pageSize);

}