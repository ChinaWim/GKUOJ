package com.oj.gkuoj.rest.backend;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.entity.Blog;
import com.oj.gkuoj.entity.Competition;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author m969130721@163.com
 * @date 19-3-10 下午3:39
 */
@Controller("backendCompetitionController")
@RequestMapping("/backend/competition")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    /**
     * 获取比赛到页面
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @return
     */
    public RestResponseVO<PageInfo> list2Page(@RequestParam(defaultValue = "1") Integer pageNum,
                                              @RequestParam(defaultValue = "20") Integer pageSize,
                                              @RequestParam(defaultValue = "") String keyword){

        return competitionService.listCompetitionVO2Page(pageSize,pageNum,keyword);
    }

    /**
     * 增加
     * @param competition
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public RestResponseVO add(Competition competition){
        return competitionService.insert(competition);
    }

    /**
     * 删除
     * @param compId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public RestResponseVO delete(Integer compId){
        return competitionService.delById(compId);
    }


    /**
     * 更新
     * @param competition
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public RestResponseVO update(Competition competition){
        return competitionService.updateById(competition);
    }





}
