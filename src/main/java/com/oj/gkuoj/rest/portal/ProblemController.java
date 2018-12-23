package com.oj.gkuoj.rest.portal;

import com.oj.gkuoj.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author m969130721@163.com
 * @date 18-12-17 上午10:37
 */
@Controller
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @RequestMapping("problemList")
    public String problemList(HttpServletRequest request){




        request.setAttribute("active2",true);
        return "portal/problem/problem_list";
    }












}
