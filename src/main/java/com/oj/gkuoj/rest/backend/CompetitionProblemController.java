package com.oj.gkuoj.rest.backend;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.entity.Competition;
import com.oj.gkuoj.entity.CompetitionProblem;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.CompetitionProblemService;
import com.oj.gkuoj.service.CompetitionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * @author m969130721@163.com
 * @date 19-3-10 下午4:03
 */

/**
 * @author m969130721@163.com
 * @date 19-3-10 下午3:39
 */
@Controller("backendCompetitionProblemController")
@RequestMapping("/backend/competitionProblem")
@Slf4j
public class CompetitionProblemController {

    @Autowired
    private CompetitionProblemService competitionProblemService;

    /**
     * 获取比赛题目
     *
     * @param compId
     * @return
     */
    @RequestMapping("/listByCompId")
    @ResponseBody
    public RestResponseVO listByCompId(@RequestParam(defaultValue = "-1") Integer compId) {
        return competitionProblemService.listVOByCompetitionId(compId);
    }

    /**
     * 增加-更新
     *
     * @param competitionProblem
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public RestResponseVO save(CompetitionProblem competitionProblem) {

        if (competitionProblem.getId() != null) {
            return competitionProblemService.updateById(competitionProblem);
        } else {
            return competitionProblemService.insert(competitionProblem);
        }


    }

    /**
     * 删除
     * @param competitionProblemId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public RestResponseVO delete(Integer competitionProblemId) {
        return competitionProblemService.delById(competitionProblemId);
    }


}
