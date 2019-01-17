package com.oj.gkuoj.service.impl;

import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.response.RestResponseVO;
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
     public RestResponseVO getById(Integer competitionId) {
          if (competitionId == null) {
               return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
          }
          Competition competition = competitionMapper.selectByPrimaryKey(competitionId);
          return RestResponseVO.createBySuccess(competition);
     }

     @Override
     public RestResponseVO insert(Competition competition) {
          if (competition == null) {
               return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
          }
          int effect = competitionMapper.insertSelective(competition);
          return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.ADD_SUCCESS)
                  : RestResponseVO.createByErrorMessage(StringConst.ADD_FAIL);
     }

     @Override
     public RestResponseVO delById(Integer id) {
          if (id == null) {
               return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
          }
          int effect = competitionMapper.deleteByPrimaryKey(id);
          return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.DEL_SUCCESS)
                  : RestResponseVO.createByErrorMessage(StringConst.DEL_FAIL);
     }

     @Override
     public RestResponseVO update(Competition competition) {
          if (competition == null) {
               return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
          }
          int effect = competitionMapper.updateByPrimaryKeySelective(competition);
          return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                  : RestResponseVO.createByErrorMessage(StringConst.UPDATE_FAIL);
     }
}
