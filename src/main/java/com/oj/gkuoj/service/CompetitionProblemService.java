package com.oj.gkuoj.service;

import com.oj.gkuoj.entity.CompetitionProblem;
import com.oj.gkuoj.response.CompetitionProblemVO;
import com.oj.gkuoj.response.RestResponseVO;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 19-2-16 下午3:11
 */
public interface CompetitionProblemService {

    RestResponseVO getById(Integer id);

    RestResponseVO insert(CompetitionProblem competitionProblem);

    RestResponseVO delById(Integer id);

    RestResponseVO updateById(CompetitionProblem competitionProblem);

    RestResponseVO<List<CompetitionProblemVO>> listVOByCompetitionId(Integer competitionId);

    RestResponseVO<Integer> getScoreByCompIdProblemId(Integer compId,Integer problemId);

}
