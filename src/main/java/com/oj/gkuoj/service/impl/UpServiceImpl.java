package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.ServerResponse;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.dao.UpMapper;
import com.oj.gkuoj.entity.Register;
import com.oj.gkuoj.entity.Up;
import com.oj.gkuoj.service.UpService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:59
 */
public class UpServiceImpl implements UpService {
    @Autowired
    private UpMapper upMapper;


    @Override
    public ServerResponse insert(Up up) {
        int effect = upMapper.insertSelective(up);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public ServerResponse delById(Integer id) {
        int effect = upMapper.deleteByPrimaryKey(id);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public ServerResponse update(Up up) {
        int effect = upMapper.updateByPrimaryKeySelective(up);
        return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : ServerResponse.createByErrorMessage(StringConst.UPDATE_FAIL);
    }
}
