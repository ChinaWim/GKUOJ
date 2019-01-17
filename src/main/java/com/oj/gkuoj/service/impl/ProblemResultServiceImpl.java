package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.response.RestResponseVO;
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
    public RestResponseVO<ProblemResult> getById(Integer problemResultId) {
        if (problemResultId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        ProblemResult problemResult = problemResultMapper.selectByPrimaryKey(problemResultId);
        return problemResult != null ? RestResponseVO.createBySuccess(problemResult)
                : RestResponseVO.createByError();
    }

    @Override
    public RestResponseVO delById(Integer problemResultId) {
        if (problemResultId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = problemResultMapper.deleteByPrimaryKey(problemResultId);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public RestResponseVO insert(ProblemResult problemResult) {
        if (problemResult == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = problemResultMapper.insertSelective(problemResult);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.DEL_FAIL);
    }
}
