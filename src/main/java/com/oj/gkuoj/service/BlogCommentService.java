package com.oj.gkuoj.service;

import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.entity.BlogComment;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:48
 */
public interface BlogCommentService {
    RestResponseVO getById(Integer blogCommentId);

    RestResponseVO insert(BlogComment blogComment);

    RestResponseVO delById(Integer id);

    RestResponseVO update(BlogComment blogComment);


}
