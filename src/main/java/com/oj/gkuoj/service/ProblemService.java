package com.oj.gkuoj.service;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.response.ServerResponseVO;
import com.oj.gkuoj.entity.Problem;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:44
 */
public interface ProblemService {

    ServerResponseVO<Problem> getById(Integer problemId);

    ServerResponseVO insert(Problem problem);

    ServerResponseVO delById(Integer id);

    ServerResponseVO update(Problem problem);

    ServerResponseVO<PageInfo> listProblemToPage(String keyword, Integer level, Integer categoryId, Integer pageNum, Integer pageSize);

    ServerResponseVO<List<Problem>> listSuggestProblem(Integer proCategoryId, Integer row);

    ServerResponseVO<Integer> randomProblemId();


}
