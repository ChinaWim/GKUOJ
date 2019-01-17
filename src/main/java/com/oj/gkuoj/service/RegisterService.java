package com.oj.gkuoj.service;

import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.entity.Register;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:29
 */
public interface RegisterService {

    RestResponseVO insert(Register register);

    RestResponseVO delById(Integer id);

    RestResponseVO update(Register register);

}
