package com.oj.gkuoj.service;

import com.oj.gkuoj.common.ServerResponse;
import com.oj.gkuoj.entity.Problem;
import com.oj.gkuoj.entity.ProblemResult;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:44
 */
public interface ProblemResultService {

    ServerResponse<ProblemResult> getById(Integer problemResultId);

    ServerResponse delById(Integer problemResultId);

}
