package com.oj.gkuoj.service;

import com.oj.gkuoj.common.ServerResponse;
import com.oj.gkuoj.entity.Sign;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午5:07
 */
public interface SignService {

    ServerResponse insert(Sign sign);

    ServerResponse delById(Integer id);

    ServerResponse update(Sign sign);
}
