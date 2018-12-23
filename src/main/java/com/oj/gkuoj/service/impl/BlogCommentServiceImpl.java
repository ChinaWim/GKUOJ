package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.ServerResponse;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.dao.BlogCommentMapper;
import com.oj.gkuoj.entity.BlogComment;
import com.oj.gkuoj.service.BlogCommentService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:49
 */
public class BlogCommentServiceImpl implements BlogCommentService {
    @Autowired
    private BlogCommentMapper blogCommentMapper;

    @Override
    public ServerResponse getById(Integer blogCommentId) {
        BlogComment blogComment = blogCommentMapper.selectByPrimaryKey(blogCommentId);
        return ServerResponse.createBySuccess(blogComment);
    }

    @Override
    public ServerResponse insert(BlogComment blogComment) {
        int effect = blogCommentMapper.insertSelective(blogComment);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public ServerResponse delById(Integer id) {
        int effect = blogCommentMapper.deleteByPrimaryKey(id);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public ServerResponse update(BlogComment blogComment) {
        int effect = blogCommentMapper.updateByPrimaryKeySelective(blogComment);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.UPDATE_FAIL);
    }
}
