package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.response.RestResponseVO;
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
    public RestResponseVO insert(Register register) {
        if (register == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = registerMapper.insertSelective(register);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public RestResponseVO delById(Integer id) {
        if (id == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = registerMapper.deleteByPrimaryKey(id);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public RestResponseVO update(Register register) {
        if (register == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = registerMapper.updateByPrimaryKeySelective(register);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.UPDATE_FAIL);
    }

    @Override
    public RestResponseVO registerCompetition(Integer userId, Integer compId) {
        if (userId == null || compId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int rows = registerMapper.countByUserIdAndCompId(userId, compId);
        if (rows > 0) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.COMPETITION_REPEATED_REGISTER_ERROR);
        }
        Register register = new Register();
        register.setCompId(compId);
        register.setUserId(userId);
        int effect = registerMapper.insertSelective(register);

        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.ADD_FAIL);
    }


    @Override
    public RestResponseVO isRegisterCompetition(Integer userId, Integer compId) {
        if (userId == null || compId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int rows = registerMapper.countByUserIdAndCompId(userId, compId);
        return rows > 0 ? RestResponseVO.createBySuccess()
                : RestResponseVO.createByError();
    }

}
