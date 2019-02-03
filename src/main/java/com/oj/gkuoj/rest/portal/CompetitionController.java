package com.oj.gkuoj.rest.portal;

import com.oj.gkuoj.response.CompetitionDetailVO;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.CompetitionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author m969130721@163.com
 * @date 19-2-2 下午2:48
 */
@Controller
@RequestMapping("/competition")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;


    /**
     * 跳转到比赛列表页面
     *
     * @param request
     * @return
     */
    @RequestMapping("competitionListPage")
    public String competitionListPage(HttpServletRequest request) {
        //set data
        request.setAttribute("active3", true);

        return "portal/competition/competition-list";
    }


    @RequestMapping("/listCompetition2Page")
    @ResponseBody
    public RestResponseVO listCompetition2Page(HttpServletRequest request,
                                               @RequestParam(defaultValue = "1")Integer pageNum,
                                               @RequestParam(defaultValue = "20")Integer pageSize) {

        return competitionService.listCompetitionVO2Page(pageSize,pageNum);
    }





    /**
     * 跳转到比赛报名详情页面
     * @param request
     * @param competitionId
     * @return
     */
    @RequestMapping("/competitionDetailPage")
    public String competitionDetailPage(HttpServletRequest request,Integer competitionId) {

        RestResponseVO<CompetitionDetailVO> restResponseVO = competitionService.getCompetitionDetailVOById(competitionId);
        CompetitionDetailVO competitionDetailVO = restResponseVO.getData();
        //set data
        request.setAttribute("active3", true);
        request.setAttribute("competitionDetail", competitionDetailVO);

        return "portal/competition/competition-detail";
    }


}
