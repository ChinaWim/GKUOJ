package com.oj.gkuoj.service;

import com.oj.gkuoj.common.ServerResponse;
import com.oj.gkuoj.entity.Register;
import com.oj.gkuoj.entity.Up;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:54
 */
public interface UpService {
    ServerResponse insert(Up up);

    ServerResponse delById(Integer id);

    ServerResponse update(Up up);


}
