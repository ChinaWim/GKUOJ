package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.ResponseCodeEnum;
import com.oj.gkuoj.response.ServerResponseVO;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.dao.SignMapper;
import com.oj.gkuoj.entity.Sign;
import com.oj.gkuoj.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午5:07
 */
@Service
public class SignServiceImpl implements SignService {

    @Autowired
    private SignMapper signMapper;

    @Override
    public ServerResponseVO insert(Sign sign) {
        if (sign == null) {
            return ServerResponseVO.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = signMapper.insertSelective(sign);
        return effect > 0 ? ServerResponseVO.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : ServerResponseVO.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public ServerResponseVO delById(Integer id) {
        if (id == null) {
            return ServerResponseVO.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = signMapper.deleteByPrimaryKey(id);
        return effect > 0 ? ServerResponseVO.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : ServerResponseVO.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public ServerResponseVO update(Sign sign) {
        if (sign == null) {
            return ServerResponseVO.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = signMapper.updateByPrimaryKeySelective(sign);
        return effect > 0 ? ServerResponseVO.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : ServerResponseVO.createByErrorMessage(StringConst.UPDATE_FAIL);
    }
}
