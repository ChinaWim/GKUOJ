package com.oj.gkuoj.service;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.common.ServerResponse;
import com.oj.gkuoj.entity.Problem;
import com.oj.gkuoj.entity.ProblemCategory;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:44
 */
public interface ProblemService {

    ServerResponse<Problem> getById(Integer problemId);

    ServerResponse insert(Problem problem);

    ServerResponse delById(Integer id);

    ServerResponse update(Problem problem);

    ServerResponse<PageInfo> listProblemToPage(String keyword, Integer level, Integer categoryId, Integer pageNum, Integer pageSize);

    ServerResponse<List<Problem>> listSuggestProblem(Integer proCategoryId, Integer row);

    ServerResponse<Integer> randomProblemId();


}
