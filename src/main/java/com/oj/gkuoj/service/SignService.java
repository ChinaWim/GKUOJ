package com.oj.gkuoj.service;

import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.entity.Sign;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午5:07
 */
public interface SignService {

    RestResponseVO insert(Sign sign);

    RestResponseVO delById(Integer id);

    RestResponseVO update(Sign sign);
}
