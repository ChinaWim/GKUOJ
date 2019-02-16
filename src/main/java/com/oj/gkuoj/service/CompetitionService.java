package com.oj.gkuoj.service;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.response.BlogVO;
import com.oj.gkuoj.response.CompetitionDetailVO;
import com.oj.gkuoj.response.CompetitionVO;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.entity.Competition;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:46
 */
public interface CompetitionService {

    RestResponseVO<Competition> getById(Integer competitionId);

    RestResponseVO insert(Competition competition);

    RestResponseVO delById(Integer competitionId);

    RestResponseVO updateById(Competition competition);

    RestResponseVO<CompetitionDetailVO> getCompetitionDetailVOById(Integer userId,Integer compId);

    RestResponseVO<PageInfo> listCompetitionVO2Page(Integer pageSize,Integer pageNum,String keyword);

    RestResponseVO<List<CompetitionDetailVO>> listLastCompetitionDetailVO(Integer pageSize);

}
