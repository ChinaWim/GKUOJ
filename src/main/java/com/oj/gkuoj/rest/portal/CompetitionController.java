package com.oj.gkuoj.rest.portal;

import com.oj.gkuoj.common.ExceptionStatusConst;
import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.entity.Competition;
import com.oj.gkuoj.entity.Register;
import com.oj.gkuoj.entity.User;
import com.oj.gkuoj.exception.CompetitionNotFoundException;
import com.oj.gkuoj.exception.CompetitionNotRegisterException;
import com.oj.gkuoj.exception.CompetitionNotStartedException;
import com.oj.gkuoj.response.CompetitionDetailVO;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.CompetitionService;
import com.oj.gkuoj.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

/**
 * @author m969130721@163.com
 * @date 19-2-2 下午2:48
 */
@Controller
@RequestMapping("/competition")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;


    @Autowired
    private RegisterService registerService;

    /**
     * 跳转到比赛列表页面
     *
     * @param request
     * @return
     */
    @RequestMapping("/competitionListPage")
    public String competitionListPage(HttpServletRequest request) {
        //set data
        request.setAttribute("active3", true);
        return "portal/competition/competition-list";
    }

    /**
     * 返回比赛list
     *
     * @param request
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/listCompetition2Page")
    @ResponseBody
    public RestResponseVO listCompetition2Page(HttpServletRequest request,
                                               @RequestParam(defaultValue = "1") Integer pageNum,
                                               @RequestParam(defaultValue = "20") Integer pageSize,
                                               @RequestParam(defaultValue = "") String keyword) {
        return competitionService.listCompetitionVO2Page(pageSize, pageNum, keyword);
    }


    /**
     * 跳转到比赛报名详情页面
     *
     * @param request
     * @param compId
     * @return
     */
    @RequestMapping("/competitionDetailPage")
    public String competitionDetailPage(HttpServletRequest request, @AuthenticationPrincipal UserDetails userDetails, Integer compId) {
        Integer userId = null;
        if (userDetails != null) {
            userId = ((User) userDetails).getId();
        }
        RestResponseVO<CompetitionDetailVO> restResponseVO = competitionService.getCompetitionDetailVOById(userId, compId);
        CompetitionDetailVO competitionDetailVO = restResponseVO.getData();
        //set data
        request.setAttribute("active3", true);
        request.setAttribute("competitionDetail", competitionDetailVO);
        return "portal/competition/competition-detail";
    }

    /**
     * 比赛报名
     *
     * @param userDetails
     * @param compId
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public RestResponseVO register(@AuthenticationPrincipal UserDetails userDetails, Integer compId, String password) {
        if (userDetails == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.UNAUTHORIZED);
        }
        Integer userId = ((User) userDetails).getId();

        return registerService.registerCompetition(userId, compId, password);
    }


    /**
     * 前往比赛题目页面
     *
     * @param userDetails
     * @return
     */
    @RequestMapping("/gotoCompetitionProblemList")
    @ResponseBody
    public RestResponseVO gotoCompetitionProblemList(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.UNAUTHORIZED);
        }
        return RestResponseVO.createBySuccess("competition/competitionProblemListPage");

    }

    /**
     * 比赛题目页面
     *
     * @param userDetails
     * @param compId
     * @return
     */
    @RequestMapping("/competitionProblemListPage")
    public String competitionProblemPage(HttpServletRequest request, @AuthenticationPrincipal UserDetails userDetails, Integer compId) {
        if (userDetails == null) {
            return "portal/login";
        }
        Integer userId = ((User) userDetails).getId();
        Competition competition = competitionService.getById(compId).getData();
        if (competition == null) {
            throw new CompetitionNotFoundException(ExceptionStatusConst.COMPETITION_NOT_FOUND_EXP,
                    "比赛未找到");
        }
        Instant nowDate = Instant.now();
        Instant startTime = competition.getStartTime().toInstant();
        Instant endTime = competition.getEndTime().toInstant();
        boolean isStarted = nowDate.isAfter(startTime);
        boolean isClosed = nowDate.isAfter(endTime);
        long closeSecond = endTime.getEpochSecond() - nowDate.getEpochSecond();
        if (!isStarted) {
            throw new CompetitionNotStartedException(ExceptionStatusConst.COMPETITION_NOT_STARTED_EXP,
                    "比赛未开始");
        }
        RestResponseVO response = registerService.isRegisterCompetition(userId, compId);
        if (!response.isSuccess() && !isClosed) {
            throw new CompetitionNotRegisterException(ExceptionStatusConst.COMPETITION_NOT_REGISTER_EXP,
                    "你未报名该比赛");
        }

        //set data
        request.setAttribute("active3", true);
        request.setAttribute("competition", competition);
        request.setAttribute("closeSecond", closeSecond);
        return "portal/competition/competition-problemList";
    }


}
