package com.oj.gkuoj.service;

import com.oj.gkuoj.response.ServerResponseVO;
import com.oj.gkuoj.entity.Competition;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:46
 */
public interface CompetitionService {

    ServerResponseVO getById(Integer competitionId);

    ServerResponseVO insert(Competition competition);

    ServerResponseVO delById(Integer id);

    ServerResponseVO update(Competition competition);

}
