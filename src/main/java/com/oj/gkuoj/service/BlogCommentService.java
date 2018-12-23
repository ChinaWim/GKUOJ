package com.oj.gkuoj.service;

import com.oj.gkuoj.common.ServerResponse;
import com.oj.gkuoj.entity.Blog;
import com.oj.gkuoj.entity.BlogComment;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:48
 */
public interface BlogCommentService {
    ServerResponse getById(Integer blogCommentId);

    ServerResponse insert(BlogComment blogComment);

    ServerResponse delById(Integer id);

    ServerResponse update(BlogComment blogComment);


}
