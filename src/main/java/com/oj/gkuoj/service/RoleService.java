package com.oj.gkuoj.service;


import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.entity.Role;
import com.oj.gkuoj.response.RestResponseVO;

public interface RoleService {

    RestResponseVO insert(Role role);

    RestResponseVO delById(Integer id);

    RestResponseVO updateById(Role role);

    RestResponseVO<PageInfo> listRole2Page(Integer pageNum, Integer pageSize);

}
