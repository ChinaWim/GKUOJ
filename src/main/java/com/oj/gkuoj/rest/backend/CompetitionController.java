package com.oj.gkuoj.rest.backend;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.entity.Blog;
import com.oj.gkuoj.entity.Competition;
import com.oj.gkuoj.entity.User;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
     * 跳转到比赛编辑页面
     * @return
     */
    @RequestMapping("/competitionEditPage")
    public String competitionEditPage(HttpServletRequest request){

        //set data
        request.setAttribute("competitionManagerActive",true);
        request.setAttribute("competitionEditActive",true);
        return "backend/competition/competition-edit";

    }

    /**
     * 跳转到比赛页面
     * @return
     */
    @RequestMapping("/competitionListPage")
    public String competitionListPage(HttpServletRequest request){

        //set data
        request.setAttribute("competitionManagerActive",true);
        request.setAttribute("competitionActive",true);
        return "backend/competition/competition-list";

    }


    /**
     * 获取比赛到页面
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @return
     */
    @RequestMapping("/list2Page")
    @ResponseBody
    public RestResponseVO<PageInfo> list2Page(@RequestParam(defaultValue = "1") Integer pageNum,
                                              @RequestParam(defaultValue = "20") Integer pageSize,
                                              @RequestParam(defaultValue = "") String keyword){

        return competitionService.listCompetitionVO2Page(pageSize,pageNum,keyword);
    }

    /**
     * 增加-更新
     * @param competition
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public RestResponseVO save(Competition competition,
                               @AuthenticationPrincipal UserDetails userDetails){
        User user = (User) userDetails;
        if (user == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.UNAUTHORIZED);
        }
        competition.setUserId(user.getId());
        if(competition.getId() != null){
            return competitionService.updateById(competition);
        }else {
            return competitionService.insert(competition);
        }

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







}
