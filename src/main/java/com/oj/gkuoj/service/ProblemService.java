package com.oj.gkuoj.service;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.entity.Problem;
import com.oj.gkuoj.entity.ProblemResult;
import com.oj.gkuoj.request.ProblemRequest;
import com.oj.gkuoj.response.ProblemDetailVO;
import com.oj.gkuoj.response.ProblemResultRecentVO;
import com.oj.gkuoj.response.RestResponseVO;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:44
 */
public interface ProblemService {

    RestResponseVO<Problem> getById(Integer problemId);

    RestResponseVO insert(ProblemRequest problemRequest);

    RestResponseVO delById(Integer id);

    RestResponseVO<Problem> updateById(ProblemRequest problemRequest);

    RestResponseVO<PageInfo> listProblemVOToPage(Integer userId,Integer flag,Integer sort,String keyword, Integer level, String tagIds, Integer pageNum, Integer pageSize);

    RestResponseVO<List<ProblemDetailVO>> listSuggestProblem(Integer problemId, Integer row);

    RestResponseVO<Integer> randomProblemId();

    RestResponseVO<ProblemDetailVO> getDetailVOById(Integer problemId);

}
