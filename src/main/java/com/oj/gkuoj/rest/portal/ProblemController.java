package com.oj.gkuoj.rest.portal;

import com.oj.gkuoj.entity.Problem;
import com.oj.gkuoj.entity.ProblemCategory;
import com.oj.gkuoj.service.ProblemCategoryService;
import com.oj.gkuoj.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-17 上午10:37
 */
@Controller
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @Autowired
    private ProblemCategoryService problemCategoryService;

    /**
     * 问题列表
     * @param request
     * @param pageNum 标题、标签、分类或题目编号
     * @param pageSize
     * @param keyword
     * @param level
     * @param categoryId
     * @return
     */
    @RequestMapping("problemList")
    public String problemList(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "10") Integer pageSize, String keyword,
                              @RequestParam(defaultValue = "-1")Integer level, @RequestParam(defaultValue = "-1")Integer categoryId) {
        //题目分类
        List<ProblemCategory> problemCategoryList = problemCategoryService.listAll().getData();
        ProblemCategory problemCategory = new ProblemCategory();
        problemCategory.setName("不限");
        problemCategory.setId(-1);
        problemCategoryList.add(0, problemCategory);

        //set data
        request.setAttribute("keyword",keyword);
        request.setAttribute("level",level);
        request.setAttribute("categoryId",categoryId);
        request.setAttribute("problemCategoryList", problemCategoryList);
        request.setAttribute("active2", true);
        return "portal/problem/problem-list";
    }

    @RequestMapping("/problemDetail")
    public String problemDetail(HttpServletRequest request,Integer problemId){
        Problem problem = problemService.getById(problemId).getData();
        request.setAttribute("problem",problem);
        return "portal/problem/problem-detail";
    }
















}
