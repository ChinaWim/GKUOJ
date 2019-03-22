package com.oj.gkuoj.rest.backend;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.entity.Problem;
import com.oj.gkuoj.entity.Role;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author m969130721@163.com
 * @date 19-3-10 下午3:56
 */

@Controller("backendController")
@RequestMapping("/backend/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;


    /**
     * 跳转到题目列表页面
     *
     * @return
     */
    @RequestMapping("/problemListPage")
    public String userListPage(HttpServletRequest request) {
        request.setAttribute("questionActive",true);
        request.setAttribute("problemActive",true);
        return "backend/problem/problem-list";
    }



    @RequestMapping("/listProblem2Page")
    @ResponseBody
    public RestResponseVO<PageInfo> listProblem(@RequestParam(defaultValue = "-1") Integer sort,
                                                @RequestParam(defaultValue = "") String keyword,
                                                @RequestParam(defaultValue = "-1") Integer level,
                                                @RequestParam(defaultValue = "") String tagIds,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "20")Integer pageSize){
        return problemService.listProblemVOToPage(null,sort,keyword,level,tagIds,pageNum,pageSize);
    }



    /**
     * 添加problem
     * @param problem
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public RestResponseVO add(Problem problem){
        return problemService.insert(problem);
    }


    /**
     * 更新problem
     * @param problem
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public RestResponseVO update(Problem problem){
        return problemService.updateById(problem);
    }

    /**
     * 删除problem
     * @param problemId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public RestResponseVO delete(Integer problemId){
        return problemService.delById(problemId);
    }




}


