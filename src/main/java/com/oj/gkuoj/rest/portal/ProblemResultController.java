package com.oj.gkuoj.rest.portal;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.common.ExceptionStatusConst;
import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.entity.Competition;
import com.oj.gkuoj.entity.User;
import com.oj.gkuoj.exception.UserUnAuthorizedException;
import com.oj.gkuoj.producer.JudgeProducer;
import com.oj.gkuoj.response.ProblemResultDetailVO;
import com.oj.gkuoj.response.ProblemResultSubmitVO;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.entity.ProblemResult;
import com.oj.gkuoj.service.CompetitionService;
import com.oj.gkuoj.service.ProblemResultService;
import com.oj.gkuoj.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.Duration;
import java.time.Instant;

/**
 * @author m969130721@163.com
 * @date 18-12-26 下午5:00
 */
@Controller
@RequestMapping("/problemResult")
public class ProblemResultController {

    @Autowired
    private ProblemResultService problemResultService;

    @Autowired
    private JudgeProducer producer;

    @Autowired
    private CompetitionService competitionService;

    @Autowired
    private RegisterService registerService;

    /**
     * 跳转到测评记录列表页面
     *
     * @param request
     * @return
     */
    @RequestMapping("/problemResultListPage")
    public String problemResultListPage(HttpServletRequest request) {
        //set data
        request.setAttribute("active4", true);
        return "portal/problemResult/problemResult-list";
    }


    /**
     * 获取题目结果List
     *
     * @param problemId
     * @param pageNum
     * @param pageSize
     * @param name
     * @param type
     * @param status
     * @return
     */
    @RequestMapping("/listProblemResult2Page")
    @ResponseBody
    public RestResponseVO listProblemResult2Page(@RequestParam(required = false) Integer problemId,
                                                 @RequestParam(defaultValue = "1") Integer pageNum,
                                                 @RequestParam(defaultValue = "20") Integer pageSize,
                                                 @RequestParam(defaultValue = "", required = false) String name,
                                                 @RequestParam(defaultValue = "", required = false) String type,
                                                 @RequestParam(defaultValue = "-1", required = false) Integer status) {

        return problemResultService.listProblemResult2Page(problemId, name, type, status, pageNum, pageSize);
    }


    /**
     * 显示源码
     *
     * @param request
     * @param problemResultId
     * @return
     */
    @RequestMapping("/showSourceCodePage")
    public String showSourceCodePage(HttpServletRequest request, Integer problemResultId) {

        //set data
        RestResponseVO<ProblemResult> serverResponse = problemResultService.getById(problemResultId);
        if (serverResponse.isSuccess()) {
            request.setAttribute("sourceCode", serverResponse.getData().getSourceCode());
        } else {
            request.setAttribute("sourceCode", serverResponse.getMsg());
        }
        return "portal/problemResult/source-code";
    }


    /**
     * 提交题目代码
     *
     * @param userDetails
     * @param problemResult
     * @param bindingResult
     * @return runNum
     */
    @RequestMapping("/submit")
    @ResponseBody
    public RestResponseVO<String> submit(@AuthenticationPrincipal UserDetails userDetails, @Validated ProblemResult problemResult, BindingResult bindingResult) {
        if (userDetails == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.UNAUTHORIZED);
        }
        User user = (User) userDetails;
        if (bindingResult.hasErrors()) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }

        if (problemResult.getCompId() != null) {
            Competition competition = competitionService.getById(problemResult.getCompId()).getData();
            if (competition == null) {
                return RestResponseVO.createByErrorEnum(RestResponseEnum.COMPETITION_NOT_FOUND_ERROR);
            }
            RestResponseVO isRegistered = registerService.isRegisterCompetition(user.getId(), problemResult.getCompId());
            if (!isRegistered.isSuccess()) {
                return RestResponseVO.createByErrorEnum(RestResponseEnum.COMPETITION_NOT_REGISTER);
            }
            Instant nowDate = Instant.now();
            boolean isStarted = nowDate.isAfter(competition.getStartTime().toInstant());
            boolean isClosed = nowDate.isAfter(competition.getEndTime().toInstant());
            if (!isStarted) {
                return RestResponseVO.createByErrorEnum(RestResponseEnum.COMPETITION_NOT_STARTED_ERROR);
            }
            if (isClosed) {
                return RestResponseVO.createByErrorEnum(RestResponseEnum.COMPETITION_CLOSED_ERROR);
            }
        }


        problemResult.setUserId(user.getId());
        return producer.send(problemResult);
    }


    /**
     * todo add 金币查看表？
     * 跳转到题目结果页面
     *
     * @param request
     * @param problemResultId
     * @return
     */
    @RequestMapping("/problemResultDetailPage")
    public String problemResultPage(HttpServletRequest request, Integer problemResultId,
                                    @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            throw new UserUnAuthorizedException(ExceptionStatusConst.USER_UN_AUTHORIZE_EXP, "请先登录");
        }
        User user = (User) userDetails;
        RestResponseVO<ProblemResultDetailVO> restResponseVO = problemResultService.getById2DetailVO(problemResultId);
        ProblemResultDetailVO problemResultDetailVO = restResponseVO.getData();
        if (!problemResultDetailVO.getUserId().equals(user.getId())) {
            if (user.getGoldCount() > 0) {

            } else {

            }
        }
        //set data
        request.setAttribute("active4", true);
        request.setAttribute("problemResultDetail", problemResultDetailVO);

        return "portal/problemResult/problemResult-detail";
    }

    /**
     * 获取题目状态
     *
     * @param runNum
     * @return
     */
    @RequestMapping("/problemResultNow")
    @ResponseBody
    public RestResponseVO<ProblemResultSubmitVO> problemResultNow(String runNum) {
        return problemResultService.getByRunNum2SubmitVO(runNum);
    }


    @RequestMapping("/listProblemResultCompetitionVO2Page")
    @ResponseBody
    public RestResponseVO<PageInfo> listProblemResultCompetitionVO2Page(@AuthenticationPrincipal UserDetails userDetails,
                                                                        @RequestParam(defaultValue = "1") Integer pageNum,
                                                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                                                        Integer compId) {
        if (userDetails == null) {
            throw new UserUnAuthorizedException(ExceptionStatusConst.USER_UN_AUTHORIZE_EXP, "请先登录");
        }
        User user = ((User) userDetails);

        return problemResultService.listProblemResultCompetitionVO2Page(pageNum, pageSize, user.getId(), compId);
    }


}
