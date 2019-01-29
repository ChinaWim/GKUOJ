package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.dao.BlogCategoryMapper;
import com.oj.gkuoj.entity.BlogCategory;
import com.oj.gkuoj.entity.BlogComment;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.BlogCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 19-1-27 下午6:03
 */
@Service
public class BlogCategoryImpl implements BlogCategoryService {
    @Autowired
    private BlogCategoryMapper blogCategoryMapper;



    @Override
    public RestResponseVO getById(Integer id) {
        if (id == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        BlogCategory blogCategory = blogCategoryMapper.selectByPrimaryKey(id);
        return RestResponseVO.createBySuccess(blogCategory);
    }

    @Override
    public RestResponseVO insert(BlogCategory blogCategory) {
        if (blogCategory == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = blogCategoryMapper.insertSelective(blogCategory);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public RestResponseVO delById(Integer id) {
        if (id == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = blogCategoryMapper.deleteByPrimaryKey(id);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public RestResponseVO update(BlogCategory blogCategory) {
        if (blogCategory == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = blogCategoryMapper.updateByPrimaryKeySelective(blogCategory);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.UPDATE_FAIL);
    }

    @Override
    public RestResponseVO<List<BlogCategory>> listAll() {
        List<BlogCategory> blogCategoryList = blogCategoryMapper.listAll();
        return RestResponseVO.createBySuccess(blogCategoryList);
    }
}
