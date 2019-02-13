package com.oj.gkuoj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.common.CommonConst;
import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.dao.RegisterMapper;
import com.oj.gkuoj.response.BlogVO;
import com.oj.gkuoj.response.CompetitionDetailVO;
import com.oj.gkuoj.response.CompetitionVO;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.dao.CompetitionMapper;
import com.oj.gkuoj.entity.Competition;
import com.oj.gkuoj.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:47
 */
@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionMapper competitionMapper;

    @Autowired
    private RegisterMapper registerMapper;

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
    public RestResponseVO delById(Integer competitionId) {
        if (competitionId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = competitionMapper.deleteByPrimaryKey(competitionId);
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

    @Override
    public RestResponseVO<CompetitionDetailVO> getCompetitionDetailVOById(Integer userId, Integer compId) {
        if (compId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        CompetitionDetailVO detailVO = competitionMapper.getCompetitionDetailVOById(compId);
        int rows = 0;
        if (userId != null) {
            rows = registerMapper.countByUserIdAndCompId(userId, compId);
            if (rows > 0) {
                detailVO.setUserRegistered(true);
            }
        }
        //set status
        setCompetitionStatus(detailVO);

        return RestResponseVO.createBySuccess(detailVO);
    }

    @Override
    public RestResponseVO<PageInfo> listCompetitionVO2Page(Integer pageSize, Integer pageNum, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<CompetitionVO> competitionVOList = competitionMapper.listCompetitionVO(keyword);
        PageInfo<CompetitionVO> pageInfo = new PageInfo<>(competitionVOList);

        return RestResponseVO.createBySuccess(pageInfo);
    }

    @Override
    public RestResponseVO<List<CompetitionDetailVO>> listLastCompetitionDetailVO(Integer pageSize) {
        List<CompetitionDetailVO> competitionVOList = competitionMapper.listLastCompetitionDetailVO(pageSize);
        //set status
        for (CompetitionDetailVO detailVO : competitionVOList) {
            setCompetitionStatus(detailVO);
        }
        return RestResponseVO.createBySuccess(competitionVOList);
    }


    private void setCompetitionStatus(CompetitionDetailVO detailVO) {
        if (detailVO != null) {
            Date startTime = detailVO.getStartTime();
            Date endTime = detailVO.getEndTime();
            Date nowDate = new Date();
            boolean isNotStarted = startTime.after(nowDate);
            boolean isClose = nowDate.after(endTime);
            if (isNotStarted) {
                detailVO.setCompetitionStatus(CommonConst.CompetitionStatus.NOT_STARTED);

            } else if (isClose) {
                detailVO.setCompetitionStatus(CommonConst.CompetitionStatus.CLOSE);

            } else {
                detailVO.setCompetitionStatus(CommonConst.CompetitionStatus.PROCESSING);
            }
        }
    }

}
