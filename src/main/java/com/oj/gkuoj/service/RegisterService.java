package com.oj.gkuoj.service;

import com.oj.gkuoj.response.ServerResponseVO;
import com.oj.gkuoj.entity.Register;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:29
 */
public interface RegisterService {

    ServerResponseVO insert(Register register);

    ServerResponseVO delById(Integer id);

    ServerResponseVO update(Register register);

}
