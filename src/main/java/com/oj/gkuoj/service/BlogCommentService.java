package com.oj.gkuoj.service;

import com.oj.gkuoj.response.ServerResponseVO;
import com.oj.gkuoj.entity.BlogComment;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:48
 */
public interface BlogCommentService {
    ServerResponseVO getById(Integer blogCommentId);

    ServerResponseVO insert(BlogComment blogComment);

    ServerResponseVO delById(Integer id);

    ServerResponseVO update(BlogComment blogComment);


}
