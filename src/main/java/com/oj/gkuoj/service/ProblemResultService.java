package com.oj.gkuoj.service;

import com.oj.gkuoj.response.ServerResponseVO;
import com.oj.gkuoj.entity.ProblemResult;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:44
 */
public interface ProblemResultService {

    ServerResponseVO<ProblemResult> getById(Integer problemResultId);

    ServerResponseVO delById(Integer problemResultId);

    ServerResponseVO insert(ProblemResult problemResult);


}
