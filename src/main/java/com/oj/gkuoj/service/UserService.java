package com.oj.gkuoj.service;


import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.entity.User;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:44
 */
public interface UserService {

    RestResponseVO addSignCount(Integer userId);

    RestResponseVO<User> getById(Integer userId);

    RestResponseVO insert(User user);

    RestResponseVO delById(Integer id);

    RestResponseVO lockById(Integer id);

    RestResponseVO activeById(Integer id);

    RestResponseVO updateById(User user);

    RestResponseVO sendRegisterEmail(String email);

    RestResponseVO sendForgetEmail(String email);

    RestResponseVO forgetRestPassword(String token,String email,String password);

    RestResponseVO register(String token, User user);

    RestResponseVO<PageInfo> listRankUser2Page(Integer pageNum, Integer pageSize, String keyword);

    RestResponseVO checkLoginByAdmin(String username,String password);

    RestResponseVO<PageInfo> listUser2Page(Integer pageNum,Integer pageSize,String keyword);

}
