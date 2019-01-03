package com.oj.gkuoj.service;

import com.oj.gkuoj.response.ServerResponseVO;
import com.oj.gkuoj.entity.Sign;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午5:07
 */
public interface SignService {

    ServerResponseVO insert(Sign sign);

    ServerResponseVO delById(Integer id);

    ServerResponseVO update(Sign sign);
}
