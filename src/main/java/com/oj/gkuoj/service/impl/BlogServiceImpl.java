package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.ServerResponse;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.dao.BlogMapper;
import com.oj.gkuoj.entity.Blog;
import com.oj.gkuoj.entity.Problem;
import com.oj.gkuoj.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:36
 */
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public ServerResponse getById(Integer blogId) {
        Blog blog = blogMapper.selectByPrimaryKey(blogId);
        return ServerResponse.createBySuccess(blog);
    }

    @Override
    public ServerResponse insert(Blog blog) {
        int effect = blogMapper.insertSelective(blog);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public ServerResponse delById(Integer id) {
        int effect = blogMapper.deleteByPrimaryKey(id);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public ServerResponse update(Blog blog) {
        int effect = blogMapper.updateByPrimaryKeySelective(blog);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.UPDATE_FAIL);
    }
}
