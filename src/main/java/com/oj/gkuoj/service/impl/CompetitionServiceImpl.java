package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.ServerResponse;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.dao.CompetitionMapper;
import com.oj.gkuoj.dao.RegisterMapper;
import com.oj.gkuoj.entity.Competition;
import com.oj.gkuoj.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:47
 */
@Service
public class CompetitionServiceImpl implements CompetitionService {

     @Autowired
     private CompetitionMapper competitionMapper;

     @Override
     public ServerResponse getById(Integer competitionId) {
          Competition competition = competitionMapper.selectByPrimaryKey(competitionId);
          return ServerResponse.createBySuccess(competition);
     }

     @Override
     public ServerResponse insert(Competition competition) {
          int effect = competitionMapper.insertSelective(competition);
          return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.ADD_SUCCESS)
                  : ServerResponse.createByErrorMessage(StringConst.ADD_FAIL);
     }

     @Override
     public ServerResponse delById(Integer id) {
          int effect = competitionMapper.deleteByPrimaryKey(id);
          return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.DEL_SUCCESS)
                  : ServerResponse.createByErrorMessage(StringConst.DEL_FAIL);
     }

     @Override
     public ServerResponse update(Competition competition) {
          int effect = competitionMapper.updateByPrimaryKeySelective(competition);
          return effect > 0 ? ServerResponse.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                  : ServerResponse.createByErrorMessage(StringConst.UPDATE_FAIL);
     }
}
