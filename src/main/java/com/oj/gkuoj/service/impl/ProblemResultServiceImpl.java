package com.oj.gkuoj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.common.JudgeStatusEnum;
import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.dao.TestcaseResultMapper;
import com.oj.gkuoj.entity.TestcaseResult;
import com.oj.gkuoj.response.*;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.dao.ProblemResultMapper;
import com.oj.gkuoj.entity.ProblemResult;
import com.oj.gkuoj.service.ProblemResultService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-26 下午8:01
 */
@Service
public class ProblemResultServiceImpl implements ProblemResultService {
    @Autowired
    private ProblemResultMapper problemResultMapper;

    @Autowired
    private TestcaseResultMapper testcaseResultMapper;

    @Override
    public RestResponseVO<ProblemResult> getById(Integer problemResultId) {
        if (problemResultId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        ProblemResult problemResult = problemResultMapper.selectByPrimaryKey(problemResultId);
        return problemResult != null ? RestResponseVO.createBySuccess(problemResult)
                : RestResponseVO.createByError();
    }

    @Override
    public RestResponseVO delById(Integer problemResultId) {
        if (problemResultId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = problemResultMapper.deleteByPrimaryKey(problemResultId);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public RestResponseVO insert(ProblemResult problemResult) {
        if (problemResult == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = problemResultMapper.insertSelective(problemResult);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public RestResponseVO<PageInfo> listProblemResult2Page(Integer problemId, String name, String type, Integer status, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        List<ProblemResultVO> problemResultList = problemResultMapper.listProblemResult(problemId, name, type, status);
        for (ProblemResultVO problemResultVO : problemResultList) {
            List<TestcaseResult> testcaseResultList = testcaseResultMapper.listByProblemResultId(problemResultVO.getId());
            int baseScore = getProblemResultBaseScore(testcaseResultList);
            for (TestcaseResult testcaseResult : testcaseResultList) {
                if (JudgeStatusEnum.ACCEPTED.getStatus().equals(testcaseResult.getStatus())) {
                    problemResultVO.setScore(problemResultVO.getScore() + baseScore);
                }
            }
        }
        PageInfo<ProblemResultVO> pageInfo = new PageInfo<ProblemResultVO>(problemResultList);
        return RestResponseVO.createBySuccess(pageInfo);
    }

    @Override
    public RestResponseVO<ProblemResultSubmitVO> getByRunNum2SubmitVO(String runNum) {
        if (StringUtils.isBlank(runNum)) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        ProblemResultSubmitVO resultSubmitVO = problemResultMapper.getByRunNum2SubmitVO(runNum);
        return RestResponseVO.createBySuccess(resultSubmitVO);
    }

    @Override
    public RestResponseVO<ProblemResultDetailVO> getById2DetailVO(Integer problemResultId) {
        if (problemResultId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        ProblemResultDetailVO detailVO = problemResultMapper.getById2DetailVO(problemResultId);
        if (detailVO != null) {
            List<TestcaseResult> testcaseResultList = detailVO.getTestcaseResultList();
            if (testcaseResultList != null) {
                int baseScore = getProblemResultBaseScore(testcaseResultList);
                for (TestcaseResult testcaseResult : testcaseResultList) {
                    if (JudgeStatusEnum.ACCEPTED.getStatus().equals(testcaseResult.getStatus())) {
                        detailVO.setAcCount(detailVO.getAcCount() + 1);
                        detailVO.setScore(detailVO.getScore() + baseScore);
                    }

                }
            }
        }

        return RestResponseVO.createBySuccess(detailVO);
    }

    @Override
    public RestResponseVO<PageInfo> listProblemResultCompetitionVO2Page(Integer pageNum, Integer pageSize, Integer userId, Integer compId) {
        if (pageNum == null || pageSize == null || userId == null || compId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        PageHelper.startPage(pageNum, pageSize, true);

        List<ProblemResultCompetitionVO> list = problemResultMapper.listProblemResultCompetitionVO2Page(compId, userId);
        for (ProblemResultCompetitionVO dataVO : list) {
            List<TestcaseResult> testcaseResultList = testcaseResultMapper.listByProblemResultId(dataVO.getId());
            int baseScore = getProblemResultBaseScore(testcaseResultList);
            for (TestcaseResult testcaseResult : testcaseResultList) {
                if (JudgeStatusEnum.ACCEPTED.getStatus().equals(testcaseResult.getStatus())) {
                    dataVO.setScore(dataVO.getScore() + baseScore);
                    dataVO.setAcCount(dataVO.getAcCount() + 1);
                }
            }
        }


        PageInfo<ProblemResultCompetitionVO> pageInfo = new PageInfo<>(list);

        return RestResponseVO.createBySuccess(pageInfo);
    }


    private int getProblemResultBaseScore(List<TestcaseResult> testcaseResultList) {
        return testcaseResultList.size() == 5 ? 20 : testcaseResultList.size() == 10 ? 10 : 0;
    }

}
