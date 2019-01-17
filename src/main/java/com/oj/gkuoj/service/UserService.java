package com.oj.gkuoj.service;


import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.entity.User;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:44
 */
public interface UserService {

    RestResponseVO addSignCount(Integer userId);

    RestResponseVO<User> getById(Integer userId);

    RestResponseVO insert(User user);

    RestResponseVO delById(Integer id);

    RestResponseVO update(User user);

    RestResponseVO sendEmail(String email);


}
