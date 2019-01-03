package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.ResponseCodeEnum;
import com.oj.gkuoj.response.ServerResponseVO;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.dao.RegisterMapper;
import com.oj.gkuoj.entity.Register;
import com.oj.gkuoj.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:29
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public ServerResponseVO insert(Register register) {
        if (register == null) {
            return ServerResponseVO.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = registerMapper.insertSelective(register);
        return effect > 0 ? ServerResponseVO.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : ServerResponseVO.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public ServerResponseVO delById(Integer id) {
        if (id == null) {
            return ServerResponseVO.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = registerMapper.deleteByPrimaryKey(id);
        return effect > 0 ? ServerResponseVO.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : ServerResponseVO.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public ServerResponseVO update(Register register) {
        if (register == null) {
            return ServerResponseVO.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = registerMapper.updateByPrimaryKeySelective(register);
        return effect > 0 ? ServerResponseVO.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : ServerResponseVO.createByErrorMessage(StringConst.UPDATE_FAIL);
    }
}
