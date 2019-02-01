package com.oj.gkuoj.rest.portal;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.common.ExceptionStatusConst;
import com.oj.gkuoj.entity.Problem;
import com.oj.gkuoj.entity.ProblemResult;
import com.oj.gkuoj.entity.Tag;
import com.oj.gkuoj.entity.User;
import com.oj.gkuoj.exception.ProblemNotFoundException;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.ProblemResultService;
import com.oj.gkuoj.service.TagService;
import com.oj.gkuoj.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    private ProblemResultService problemResultService;

    @Autowired
    private TagService tagService;

    private final Integer SUGGEST_PROBLEM_ROW = 5;

    /**
     * 跳转到题目List页面
     * @param request
     * @return
     */
    @RequestMapping("/problemListPage")
    public String problemListPage(HttpServletRequest request) {
        //题目标签
        List<Tag> tagList = tagService.listAll().getData();
        Tag t = new Tag();
        t.setName("不限");
        t.setId(-1);
        tagList.add(0, t);

        //set data
        request.setAttribute("tagList", tagList);
        request.setAttribute("active2", true);
        return "portal/problem/problem-list";
    }


    /**
     * 题目列表
     * @param userDetails
     * @param pageNum
     * @param pageSize
     * @param sort
     * @param keyword
     * @param level
     * @param tagName
     * @return
     */
    @RequestMapping("/listProblem2Page")
    @ResponseBody
    public RestResponseVO<PageInfo> listProblem2Page(@AuthenticationPrincipal UserDetails userDetails,
                                                     @RequestParam(defaultValue = "1") Integer pageNum,
                                                     @RequestParam(defaultValue = "20") Integer pageSize,
                                                     @RequestParam(defaultValue = "-1", required = false) Integer sort,
                                                     @RequestParam(defaultValue = "", required = false) String keyword,
                                                     @RequestParam(defaultValue = "-1", required = false) Integer level,
                                                     @RequestParam(defaultValue = "不限", required = false) String tagName) {
        Integer userId = null;
        if (userDetails != null) {
            userId = ((User) userDetails).getId();
        }
        return problemService.listProblemToPage(userId, sort, keyword, level, tagName, pageNum, pageSize);
    }


    /**
     * 题目详情页面
     *
     * @param request
     * @param problemId
     * @return
     */
    @RequestMapping("/problemDetailPage")
    public String problemDetailPage(HttpServletRequest request, Integer problemId) {
        Problem problem = problemService.getById(problemId).getData();
        //todo
        if (problem == null) {
            throw new ProblemNotFoundException(ExceptionStatusConst.PROBLEM_NOT_FOUND_EXP, "未找到该题号的题目");
        }
        //set data
        request.setAttribute("problem", problem);
        request.setAttribute("active2", true);
        return "portal/problem/problem-detail";
    }

    /**
     * 随机返回5道推荐题目
     *
     * @param problemId
     * @return
     */
    @RequestMapping("/suggestProblemList")
    @ResponseBody
    public RestResponseVO<List<Problem>> suggestProblemList(Integer problemId) {
        return problemService.listSuggestProblem(problemId, SUGGEST_PROBLEM_ROW);
    }

    /**
     * 随机选择一道题目
     *
     * @return
     */
    @RequestMapping("/randomProblem")
    public String randomProblem(HttpServletRequest request) {
        RestResponseVO<Integer> serverResponse = problemService.randomProblemId();
        if (serverResponse.isSuccess()) {
            return "redirect:/problem/problemDetailPage?problemId=" + serverResponse.getData();
        } else {
            //fixme
            return "500";
        }
    }


}
