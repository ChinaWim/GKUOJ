package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.ResponseCodeEnum;
import com.oj.gkuoj.common.ServerResponse;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.dao.RoleMapper;
import com.oj.gkuoj.dao.UserMapper;
import com.oj.gkuoj.dao.UserRoleMapper;
import com.oj.gkuoj.service.UserService;
import com.oj.gkuoj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:45
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public ServerResponse addSignCount(Integer userId) {
        if (userId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = userMapper.addSignCount(userId);
        return effect > 0 ? ServerResponse.createBySuccess():ServerResponse.createByError();
    }

    @Override
    public ServerResponse getById(Integer userId) {
        if (userId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        User user = userMapper.selectByPrimaryKey(userId);
        return ServerResponse.createBySuccess(user);
    }

    @Override
    public ServerResponse insert(User user) {
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = userMapper.insertSelective(user);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public ServerResponse delById(Integer id) {
        if (id == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = userMapper.deleteByPrimaryKey(id);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public ServerResponse update(User user) {
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = userMapper.updateByPrimaryKeySelective(user);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.UPDATE_FAIL);
    }
}
