package com.oj.gkuoj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.common.ResponseCodeEnum;
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

import java.util.List;

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
        if (problemId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        Problem problem = problemMapper.selectByPrimaryKey(problemId);
        return ServerResponse.createBySuccess(problem);
    }

    @Override
    public ServerResponse delById(Integer id) {
        if (id == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = problemMapper.deleteByPrimaryKey(id);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public ServerResponse insert(Problem problem) {
        if (problem == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = problemMapper.insertSelective(problem);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public ServerResponse update(Problem problem) {
        if (problem == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = problemMapper.updateByPrimaryKeySelective(problem);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.UPDATE_FAIL);
    }

    @Override
    public ServerResponse<PageInfo> listProblemToPage(String keyword, Integer level, Integer categoryId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize,true);
        List<Problem> problemList = problemMapper.listAll(keyword, level, categoryId);
        PageInfo<Problem> pageInfo = new PageInfo<>(problemList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse listSuggestProblem(Integer proCategoryId,Integer row) {
        if (proCategoryId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        List<Problem> problemList = problemMapper.listSuggestProblem(proCategoryId, row);
        return ServerResponse.createBySuccess(problemList);
    }

    @Override
    public ServerResponse<Integer> randomProblemId() {
        Integer randomProblemId = problemMapper.countRandomProblemId();
        if (randomProblemId != null){
            return ServerResponse.createBySuccess(randomProblemId);
        }else {
            return ServerResponse.createByError();
        }

    }
}
