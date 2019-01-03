package com.oj.gkuoj.service;

import com.oj.gkuoj.response.ServerResponseVO;
import com.oj.gkuoj.entity.Blog;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:35
 */
public interface BlogService {

    ServerResponseVO getById(Integer blogId);

    ServerResponseVO insert(Blog blog);

    ServerResponseVO delById(Integer id);

    ServerResponseVO update(Blog blog);


}
