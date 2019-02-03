package com.oj.gkuoj.service;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.response.CompetitionDetailVO;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.entity.Competition;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:46
 */
public interface CompetitionService {

    RestResponseVO getById(Integer competitionId);

    RestResponseVO insert(Competition competition);

    RestResponseVO delById(Integer id);

    RestResponseVO update(Competition competition);

    RestResponseVO<CompetitionDetailVO> getCompetitionDetailVOById(Integer competitionId);

    RestResponseVO<PageInfo> listCompetitionVO2Page(Integer pageSize,Integer pageNum);

}
