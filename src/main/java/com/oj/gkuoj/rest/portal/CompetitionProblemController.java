package com.oj.gkuoj.rest.portal;

import com.oj.gkuoj.response.CompetitionProblemVO;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.CompetitionProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 19-2-16 下午9:58
 */
@RequestMapping("/competitionProblem")
@Controller
public class CompetitionProblemController {

    @Autowired
    private CompetitionProblemService competitionProblemService;

    @RequestMapping("/listVOByCompId")
    @ResponseBody
    public RestResponseVO<List<CompetitionProblemVO>> listVOByCompId(Integer compId){
        return competitionProblemService.listVOByCompetitionId(compId);
    }


}
