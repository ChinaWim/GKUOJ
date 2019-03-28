package com.oj.gkuoj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.common.CommonConst;
import com.oj.gkuoj.common.JudgeStatusEnum;
import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.dao.ProblemMapper;
import com.oj.gkuoj.dao.ProblemResultMapper;
import com.oj.gkuoj.entity.Problem;
import com.oj.gkuoj.response.ProblemDetailVO;
import com.oj.gkuoj.response.ProblemVO;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.service.ProblemService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:44
 */
@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemMapper problemMapper;

    @Autowired
    private ProblemResultMapper problemResultMapper;

    @Override
    public RestResponseVO getById(Integer problemId) {
        if (problemId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        Problem problem = problemMapper.selectByPrimaryKey(problemId);
        return RestResponseVO.createBySuccess(problem);
    }

    @Override
    public RestResponseVO delById(Integer id) {
        if (id == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = problemMapper.deleteByPrimaryKey(id);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public RestResponseVO insert(Problem problem) {
        if (problem == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = problemMapper.insertSelective(problem);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public RestResponseVO updateById(Problem problem) {
        if (problem == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = problemMapper.updateByPrimaryKeySelective(problem);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.UPDATE_FAIL);
    }

    @Override
    public RestResponseVO<PageInfo> listProblemVOToPage(Integer userId, Integer sort, String keyword, Integer level, String tagIds, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        List<Integer> tagIdsList = null;
        if (StringUtils.isNoneBlank(tagIds)) {
            tagIdsList = new ArrayList<>();
            for (String tagId : tagIds.split(",")) {
                tagIdsList.add(Integer.parseInt(tagId));
            }
        }

        List<ProblemVO> problemList = problemMapper.listAll2VO(sort, keyword, level, tagIdsList);
        if (userId != null) {
            for (ProblemVO problemVO : problemList) {
                int totalCount = problemResultMapper.countUserIdProblemId(userId, problemVO.getId());
                if (totalCount > 0) {
                    int acCount = problemResultMapper.countUserIdProblemIdByStatus(userId, problemVO.getId(), JudgeStatusEnum.ACCEPTED.getStatus());
                    if (acCount > 0) {
                        problemVO.setUserStatus(CommonConst.ProblemUserStatus.PASSED);
                    } else {
                        problemVO.setUserStatus(CommonConst.ProblemUserStatus.TRYING);
                    }
                }
            }
        }
        PageInfo<ProblemVO> pageInfo = new PageInfo<>(problemList);
        return RestResponseVO.createBySuccess(pageInfo);
    }

    @Override
    public RestResponseVO listSuggestProblem(Integer problemId, Integer row) {
        if (problemId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        List<ProblemDetailVO> problemList = problemMapper.listSuggestProblem(problemId, row);
        return RestResponseVO.createBySuccess(problemList);
    }

    @Override
    public RestResponseVO<Integer> randomProblemId() {
        Integer randomProblemId = problemMapper.countRandomProblemId();
        if (randomProblemId != null) {
            return RestResponseVO.createBySuccess(randomProblemId);
        } else {
            return RestResponseVO.createByError();
        }

    }

    @Override
    public RestResponseVO<ProblemDetailVO> getDetailVOById(Integer problemId) {
        if (problemId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        ProblemDetailVO problemDetailVO = problemMapper.getDetailVOById(problemId);
        return RestResponseVO.createBySuccess(problemDetailVO);
    }
}
