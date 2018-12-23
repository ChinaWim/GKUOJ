package com.oj.gkuoj.controller.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author m969130721@163.com
 * @date 18-12-17 上午10:37
 */
@Controller
@RequestMapping("/problem")
public class ProblemController {

    @RequestMapping("problemList")
    public String problemList(){
        return "portal/problem/problem_list";
    }












}
