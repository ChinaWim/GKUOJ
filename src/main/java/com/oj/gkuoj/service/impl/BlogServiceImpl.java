package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.ResponseCodeEnum;
import com.oj.gkuoj.response.ServerResponseVO;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.dao.BlogMapper;
import com.oj.gkuoj.entity.Blog;
import com.oj.gkuoj.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:36
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public ServerResponseVO getById(Integer blogId) {
        if (blogId == null) {
            return ServerResponseVO.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        Blog blog = blogMapper.selectByPrimaryKey(blogId);
        return ServerResponseVO.createBySuccess(blog);
    }

    @Override
    public ServerResponseVO insert(Blog blog) {
        if (blog == null) {
            return ServerResponseVO.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = blogMapper.insertSelective(blog);
        return effect > 0 ? ServerResponseVO.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : ServerResponseVO.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public ServerResponseVO delById(Integer id) {
        if (id == null) {
            return ServerResponseVO.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = blogMapper.deleteByPrimaryKey(id);
        return effect > 0 ? ServerResponseVO.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : ServerResponseVO.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public ServerResponseVO update(Blog blog) {
        if (blog == null) {
            return ServerResponseVO.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = blogMapper.updateByPrimaryKeySelective(blog);
        return effect > 0 ? ServerResponseVO.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : ServerResponseVO.createByErrorMessage(StringConst.UPDATE_FAIL);
    }
}
