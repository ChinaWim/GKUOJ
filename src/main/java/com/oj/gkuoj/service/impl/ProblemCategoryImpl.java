package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.ServerResponse;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.dao.ProblemCategoryMapper;
import com.oj.gkuoj.entity.ProblemCategory;
import com.oj.gkuoj.service.ProblemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午3:43
 */
public class ProblemCategoryImpl implements ProblemCategoryService {
    @Autowired
    private ProblemCategoryMapper categoryMapper;

    @Override
    public ServerResponse listAll() {
        List<ProblemCategory> problemCategoryList = categoryMapper.listAll();
        return ServerResponse.createBySuccess(problemCategoryList);
    }

    @Override
    public ServerResponse insert(ProblemCategory problemCategory) {
        int effect = categoryMapper.insertSelective(problemCategory);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public ServerResponse delById(Integer id) {
        int effect = categoryMapper.deleteByPrimaryKey(id);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public ServerResponse update(ProblemCategory problemCategory) {
        int effect = categoryMapper.updateByPrimaryKeySelective(problemCategory);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.UPDATE_FAIL);
    }
}
