package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.ResponseCodeEnum;
import com.oj.gkuoj.response.ServerResponseVO;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.dao.CompetitionMapper;
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
     public ServerResponseVO getById(Integer competitionId) {
          if (competitionId == null) {
               return ServerResponseVO.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                       ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
          }
          Competition competition = competitionMapper.selectByPrimaryKey(competitionId);
          return ServerResponseVO.createBySuccess(competition);
     }

     @Override
     public ServerResponseVO insert(Competition competition) {
          if (competition == null) {
               return ServerResponseVO.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                       ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
          }
          int effect = competitionMapper.insertSelective(competition);
          return effect > 0 ? ServerResponseVO.createBySuccessMessage(StringConst.ADD_SUCCESS)
                  : ServerResponseVO.createByErrorMessage(StringConst.ADD_FAIL);
     }

     @Override
     public ServerResponseVO delById(Integer id) {
          if (id == null) {
               return ServerResponseVO.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                       ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
          }
          int effect = competitionMapper.deleteByPrimaryKey(id);
          return effect > 0 ? ServerResponseVO.createBySuccessMessage(StringConst.DEL_SUCCESS)
                  : ServerResponseVO.createByErrorMessage(StringConst.DEL_FAIL);
     }

     @Override
     public ServerResponseVO update(Competition competition) {
          if (competition == null) {
               return ServerResponseVO.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                       ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
          }
          int effect = competitionMapper.updateByPrimaryKeySelective(competition);
          return effect > 0 ? ServerResponseVO.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                  : ServerResponseVO.createByErrorMessage(StringConst.UPDATE_FAIL);
     }
}
