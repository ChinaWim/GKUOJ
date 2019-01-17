package com.oj.gkuoj.service;

import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.entity.Blog;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:35
 */
public interface BlogService {

    RestResponseVO getById(Integer blogId);

    RestResponseVO insert(Blog blog);

    RestResponseVO delById(Integer id);

    RestResponseVO update(Blog blog);


}
