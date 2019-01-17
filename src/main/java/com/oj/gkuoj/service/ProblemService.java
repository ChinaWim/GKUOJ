package com.oj.gkuoj.service;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.entity.Problem;
import com.oj.gkuoj.response.RestResponseVO;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:44
 */
public interface ProblemService {

    RestResponseVO<Problem> getById(Integer problemId);

    RestResponseVO insert(Problem problem);

    RestResponseVO delById(Integer id);

    RestResponseVO update(Problem problem);

    RestResponseVO<PageInfo> listProblemToPage(String keyword, Integer level, String tagName, Integer pageNum, Integer pageSize);

    RestResponseVO<List<Problem>> listSuggestProblem(Integer problemId, Integer row);

    RestResponseVO<Integer> randomProblemId();

}
