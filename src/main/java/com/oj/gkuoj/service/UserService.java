package com.oj.gkuoj.service;


import com.oj.gkuoj.common.ServerResponse;
import com.oj.gkuoj.entity.Blog;
import com.oj.gkuoj.entity.User;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:44
 */
public interface UserService {

    ServerResponse addSignCount(Integer userId);

    ServerResponse getById(Integer userId);

    ServerResponse insert(User user);

    ServerResponse delById(Integer id);

    ServerResponse update(User user);


}
