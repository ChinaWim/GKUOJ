package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.ResponseCodeEnum;
import com.oj.gkuoj.response.ServerResponseVO;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.dao.ProblemCategoryMapper;
import com.oj.gkuoj.entity.ProblemCategory;
import com.oj.gkuoj.service.ProblemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午3:43
 */
@Service
public class ProblemCategoryImpl implements ProblemCategoryService {
    @Autowired
    private ProblemCategoryMapper categoryMapper;

    @Override
    public ServerResponseVO<List<ProblemCategory>> listAll() {
        List<ProblemCategory> problemCategoryList = categoryMapper.listAll();
        return ServerResponseVO.createBySuccess(problemCategoryList);
    }

    @Override
    public ServerResponseVO insert(ProblemCategory problemCategory) {
        if (problemCategory == null) {
            return ServerResponseVO.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = categoryMapper.insertSelective(problemCategory);
        return effect > 0 ? ServerResponseVO.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : ServerResponseVO.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public ServerResponseVO delById(Integer id) {
        if (id == null) {
            return ServerResponseVO.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = categoryMapper.deleteByPrimaryKey(id);
        return effect > 0 ? ServerResponseVO.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : ServerResponseVO.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public ServerResponseVO update(ProblemCategory problemCategory) {
        if (problemCategory == null) {
            return ServerResponseVO.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = categoryMapper.updateByPrimaryKeySelective(problemCategory);
        return effect > 0 ? ServerResponseVO.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : ServerResponseVO.createByErrorMessage(StringConst.UPDATE_FAIL);
    }
}
