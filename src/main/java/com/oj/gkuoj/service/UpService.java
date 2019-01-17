package com.oj.gkuoj.service;

import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.entity.Up;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:54
 */
public interface UpService {
    RestResponseVO insert(Up up);

    RestResponseVO delById(Integer id);

    RestResponseVO update(Up up);


}
