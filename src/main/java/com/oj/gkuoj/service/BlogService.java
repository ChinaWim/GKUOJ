package com.oj.gkuoj.service;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.response.BlogDetailVO;
import com.oj.gkuoj.response.BlogListVO;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.entity.Blog;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:35
 */
public interface BlogService {

    RestResponseVO<Blog> getById(Integer blogId);

    RestResponseVO insert(Blog blog);

    RestResponseVO delById(Integer id);

    RestResponseVO update(Blog blog);

    RestResponseVO<PageInfo> listBlogVO2(Integer pageNum, Integer pageSize, String keyword, Integer bcId);

    RestResponseVO<BlogDetailVO> getBlogDetailVOById(Integer blogId);

    RestResponseVO updateViewCount(Integer blogId);

}
