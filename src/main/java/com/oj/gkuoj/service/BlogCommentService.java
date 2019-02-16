package com.oj.gkuoj.service;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.response.BlogCommentVO;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.entity.BlogComment;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:48
 */
public interface BlogCommentService {
    RestResponseVO getById(Integer blogCommentId);

    RestResponseVO insert(BlogComment blogComment);

    RestResponseVO delById(Integer id);

    RestResponseVO updateById(BlogComment blogComment);

    RestResponseVO<PageInfo> listByBlogId2Page(Integer userId,Integer sort, Integer pageNum, Integer pageSize, Integer blogId);
}
