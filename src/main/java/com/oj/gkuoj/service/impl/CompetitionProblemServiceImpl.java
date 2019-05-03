package com.oj.gkuoj.service.impl;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.dao.CompetitionProblemMapper;
import com.oj.gkuoj.entity.CompetitionProblem;
import com.oj.gkuoj.response.CompetitionProblemVO;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.CompetitionProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 19-2-16 下午3:18
 */
@Service
public class CompetitionProblemServiceImpl implements CompetitionProblemService {

    @Autowired
    private CompetitionProblemMapper competitionProblemMapper;
    @Override
    public RestResponseVO getById(Integer id) {
        if (id == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        CompetitionProblem competitionProblem = competitionProblemMapper.selectByPrimaryKey(id);
        return RestResponseVO.createBySuccess(competitionProblem);
    }

    @Override
    public RestResponseVO insert(CompetitionProblem competitionProblem) {
        if (competitionProblem == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }

        CompetitionProblem competitionProblemFromDB = competitionProblemMapper.getByCompIdProblemId(competitionProblem.getCompId(), competitionProblem.getProblemId());
        if (competitionProblemFromDB != null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.COMPETITION_PROBLEM_REPEATED_ERROR);
        }
        int effect = competitionProblemMapper.insertSelective(competitionProblem);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public RestResponseVO delById(Integer id) {
        if (id == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = competitionProblemMapper.deleteByPrimaryKey(id);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public RestResponseVO updateById(CompetitionProblem competitionProblem) {
        if (competitionProblem == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = competitionProblemMapper.updateByPrimaryKeySelective(competitionProblem);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.UPDATE_FAIL);
    }

    @Override
    public RestResponseVO<List<CompetitionProblemVO>> listVOByCompetitionId(Integer competitionId) {
        if (competitionId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }

        List<CompetitionProblemVO> competitionProblemVOList = competitionProblemMapper.listVOByCompetitionId(competitionId);
        return RestResponseVO.createBySuccess(competitionProblemVOList);
    }

    @Override
    public RestResponseVO<Integer> getScoreByCompIdProblemId(Integer compId, Integer problemId) {
        if (compId == null || problemId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        Integer score = competitionProblemMapper.getScoreByCompIdProblemId(compId, problemId);
        return RestResponseVO.createBySuccess(score);
    }
}
