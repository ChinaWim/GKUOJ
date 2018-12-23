package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.ServerResponse;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.dao.ProblemMapper;
import com.oj.gkuoj.dao.ProblemResultMapper;
import com.oj.gkuoj.dao.TestcaseResultMapper;
import com.oj.gkuoj.entity.Problem;
import com.oj.gkuoj.entity.ProblemCategory;
import com.oj.gkuoj.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:44
 */
@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public ServerResponse getById(Integer problemId) {
        Problem problem = problemMapper.selectByPrimaryKey(problemId);
        return ServerResponse.createBySuccess(problem);
    }

    @Override
    public ServerResponse delById(Integer id) {
        int effect = problemMapper.deleteByPrimaryKey(id);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public ServerResponse insert(Problem problem) {
        int effect = problemMapper.insertSelective(problem);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public ServerResponse update(Problem problem) {
        int effect = problemMapper.updateByPrimaryKeySelective(problem);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.UPDATE_FAIL);
    }
}
