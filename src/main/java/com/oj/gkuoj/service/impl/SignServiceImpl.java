package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.ResponseCodeEnum;
import com.oj.gkuoj.common.ServerResponse;
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
    public ServerResponse insert(Sign sign) {
        if (sign == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = signMapper.insertSelective(sign);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public ServerResponse delById(Integer id) {
        if (id == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = signMapper.deleteByPrimaryKey(id);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public ServerResponse update(Sign sign) {
        if (sign == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        int effect = signMapper.updateByPrimaryKeySelective(sign);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.UPDATE_FAIL);
    }
}
