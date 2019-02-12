package com.oj.gkuoj.service;

import com.oj.gkuoj.response.ProblemResultSubmitVO;
import com.oj.gkuoj.response.ProblemResultVO;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.entity.ProblemResult;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:44
 */
public interface ProblemResultService {

    RestResponseVO<ProblemResult> getById(Integer problemResultId);

    RestResponseVO delById(Integer problemResultId);

    RestResponseVO insert(ProblemResult problemResult);


    RestResponseVO listProblemResult2Page(Integer problemId, String name, String type, Integer status, Integer pageNum,Integer pageSize);

    RestResponseVO<ProblemResultSubmitVO> getByRunNum2SubmitVO(String runNum);

}
