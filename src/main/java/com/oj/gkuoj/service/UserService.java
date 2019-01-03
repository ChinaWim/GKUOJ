package com.oj.gkuoj.service;


import com.oj.gkuoj.response.ServerResponseVO;
import com.oj.gkuoj.entity.User;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:44
 */
public interface UserService {

    ServerResponseVO addSignCount(Integer userId);

    ServerResponseVO<User> getById(Integer userId);

    ServerResponseVO insert(User user);

    ServerResponseVO delById(Integer id);

    ServerResponseVO update(User user);



}
