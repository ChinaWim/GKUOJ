package com.oj.gkuoj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.dao.UpMapper;
import com.oj.gkuoj.entity.Up;
import com.oj.gkuoj.response.BlogDetailVO;
import com.oj.gkuoj.response.BlogListVO;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.dao.BlogMapper;
import com.oj.gkuoj.entity.Blog;
import com.oj.gkuoj.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:36
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private UpMapper upMapper;


    @Override
    public RestResponseVO<Blog> getById(Integer blogId) {
        if (blogId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        Blog blog = blogMapper.selectByPrimaryKey(blogId);
        return RestResponseVO.createBySuccess(blog);
    }

    @Override
    public RestResponseVO insert(Blog blog) {
        if (blog == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = blogMapper.insertSelective(blog);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public RestResponseVO delById(Integer id) {
        if (id == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = blogMapper.deleteByPrimaryKey(id);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public RestResponseVO update(Blog blog) {
        if (blog == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = blogMapper.updateByPrimaryKeySelective(blog);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.UPDATE_FAIL);
    }

    @Override
    public RestResponseVO<PageInfo> listBlogVO2(Integer pageNum, Integer pageSize, String keyword, Integer bcId) {
        PageHelper.startPage(pageNum, pageSize, true);
        List<BlogListVO> list = blogMapper.list2BlogVO(keyword, bcId);
        PageInfo<BlogListVO> pageInfo = new PageInfo<>(list);
        return RestResponseVO.createBySuccess(pageInfo);
    }

    @Override
    public RestResponseVO<BlogDetailVO> getBlogDetailVOById(Integer blogId, Integer userId) {
        if (blogId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        BlogDetailVO blogDetailVO = blogMapper.getBlogDetailVO(blogId);
        if (userId != null) {
            Up up = upMapper.getByBlogIdUserId(blogId, userId);
            if (up != null) {
                blogDetailVO.setUserUpStatus(up.getStatus());
            }
        }
        return RestResponseVO.createBySuccess(blogDetailVO);
    }

    @Override
    public RestResponseVO updateViewCount(Integer blogId) {
        if (blogId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = blogMapper.updateViewCountIncrease(blogId);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.UPDATE_FAIL);
    }
}
