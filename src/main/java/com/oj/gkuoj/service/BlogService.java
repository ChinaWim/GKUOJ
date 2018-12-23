package com.oj.gkuoj.service;

import com.oj.gkuoj.common.ServerResponse;
import com.oj.gkuoj.entity.Blog;
import com.oj.gkuoj.entity.Problem;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:35
 */
public interface BlogService {

    ServerResponse getById(Integer blogId);

    ServerResponse insert(Blog blog);

    ServerResponse delById(Integer id);

    ServerResponse update(Blog blog);


}
