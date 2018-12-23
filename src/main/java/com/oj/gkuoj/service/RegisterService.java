package com.oj.gkuoj.service;

import com.oj.gkuoj.common.ServerResponse;
import com.oj.gkuoj.entity.ProblemCategory;
import com.oj.gkuoj.entity.Register;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:29
 */
public interface RegisterService {

    ServerResponse insert(Register register);

    ServerResponse delById(Integer id);

    ServerResponse update(Register register);

}
