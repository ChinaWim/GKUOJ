package com.oj.gkuoj.rest.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author m969130721@163.com
 * @date 19-2-2 下午2:48
 */
@Controller
@RequestMapping("/competition")
public class CompetitionController {

    /**
     * 跳转到比赛列表页面
     * @param request
     * @return
     */
    @RequestMapping("competitionListPage")
    public String competitionListPage(HttpServletRequest request) {

        //set data
        request.setAttribute("active3",true);

        return "portal/competition/competition-list";
    }


}
