package com.oj.gkuoj.service;

import com.oj.gkuoj.response.ServerResponseVO;
import com.oj.gkuoj.entity.Up;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:54
 */
public interface UpService {
    ServerResponseVO insert(Up up);

    ServerResponseVO delById(Integer id);

    ServerResponseVO update(Up up);


}
