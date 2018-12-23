package com.oj.gkuoj.service;

import com.oj.gkuoj.common.ServerResponse;
import com.oj.gkuoj.entity.Competition;
import com.oj.gkuoj.entity.Problem;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:46
 */
public interface CompetitionService {

    ServerResponse getById(Integer competitionId);

    ServerResponse insert(Competition competition);

    ServerResponse delById(Integer id);

    ServerResponse update(Competition competition);

}
