package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.ResponseCodeEnum;
import com.oj.gkuoj.common.ServerResponse;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.dao.ProblemResultMapper;
import com.oj.gkuoj.entity.ProblemResult;
import com.oj.gkuoj.service.ProblemResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author m969130721@163.com
 * @date 18-12-26 下午8:01
 */
@Service
public class ProblemResultServiceImpl implements ProblemResultService {
    @Autowired
    private ProblemResultMapper problemResultMapper;

    @Override
    public ServerResponse<ProblemResult> getById(Integer problemResultId) {
        if (problemResultId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        ProblemResult problemResult = problemResultMapper.selectByPrimaryKey(problemResultId);
        return problemResult != null ? ServerResponse.createBySuccess(problemResult)
                : ServerResponse.createByError();
    }

    @Override
    public ServerResponse delById(Integer problemResultId) {
        if (problemResultId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = problemResultMapper.deleteByPrimaryKey(problemResultId);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.DEL_FAIL);
    }
}
