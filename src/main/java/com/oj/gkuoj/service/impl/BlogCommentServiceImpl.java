package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.ResponseCodeEnum;
import com.oj.gkuoj.response.ServerResponseVO;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.dao.BlogCommentMapper;
import com.oj.gkuoj.entity.BlogComment;
import com.oj.gkuoj.service.BlogCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:49
 */
@Service
public class BlogCommentServiceImpl implements BlogCommentService {
    @Autowired
    private BlogCommentMapper blogCommentMapper;

    @Override
    public ServerResponseVO getById(Integer blogCommentId) {
        if (blogCommentId == null) {
            return ServerResponseVO.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        BlogComment blogComment = blogCommentMapper.selectByPrimaryKey(blogCommentId);
        return ServerResponseVO.createBySuccess(blogComment);
    }

    @Override
    public ServerResponseVO insert(BlogComment blogComment) {
        if (blogComment == null) {
            return ServerResponseVO.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = blogCommentMapper.insertSelective(blogComment);
        return effect > 0 ? ServerResponseVO.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : ServerResponseVO.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public ServerResponseVO delById(Integer id) {
        if (id == null) {
            return ServerResponseVO.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = blogCommentMapper.deleteByPrimaryKey(id);
        return effect > 0 ? ServerResponseVO.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : ServerResponseVO.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public ServerResponseVO update(BlogComment blogComment) {
        if (blogComment == null) {
            return ServerResponseVO.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = blogCommentMapper.updateByPrimaryKeySelective(blogComment);
        return effect > 0 ? ServerResponseVO.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : ServerResponseVO.createByErrorMessage(StringConst.UPDATE_FAIL);
    }
}
