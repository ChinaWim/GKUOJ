package com.oj.gkuoj.rest.portal;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.entity.User;
import com.oj.gkuoj.producer.JudgeProducer;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.entity.ProblemResult;
import com.oj.gkuoj.service.ProblemResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author m969130721@163.com
 * @date 18-12-26 下午5:00
 */
@Controller
@RequestMapping("/problemResult")
public class ProblemResultController {

    @Autowired
    private ProblemResultService problemResultService;

    @Autowired
    private JudgeProducer producer;

    /**
     * 测评记录列表页面
     *
     * @param request
     * @return
     */
    @RequestMapping("/problemResultListPage")
    public String problemResultListPage(HttpServletRequest request, @RequestParam(required = false) Integer problemId,
                                        @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "30") Integer pageSize,
                                        @RequestParam(defaultValue = "")String name, String type, @RequestParam(required = false) Integer status) {

        RestResponseVO<PageInfo> responseVO = problemResultService.listProblemResult2Page(problemId, name, type, status, pageNum, pageSize);
        PageInfo pageInfo = responseVO.getData();


        //set data
        request.setAttribute("active5", true);
        request.setAttribute("problemId",problemId);
        request.setAttribute("pageNum",pageNum);
        request.setAttribute("name",name);
        request.setAttribute("type",type);
        request.setAttribute("status",status);
        request.setAttribute("problemResultList", pageInfo.getList());



        return "portal/problemResult/problemResult-list";
    }


    /**
     * 显示源码
     *
     * @param request
     * @param problemResultId
     * @return
     */
    @RequestMapping("/showSourceCodePage")
    public String showSourceCodePage(HttpServletRequest request, Integer problemResultId) {

        //set data
        RestResponseVO<ProblemResult> serverResponse = problemResultService.getById(problemResultId);
        if (serverResponse.isSuccess()) {
            request.setAttribute("sourceCode", serverResponse.getData().getSourceCode());
        } else {
            request.setAttribute("sourceCode", serverResponse.getMsg());
        }
        return "portal/problemResult/source-code";
    }

    @RequestMapping("/submit")
    @ResponseBody
    public RestResponseVO submit(Authentication authentication, @Validated ProblemResult problemResult, BindingResult bindingResult) {
        if (authentication == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.UNAUTHORIZED);
        }
        if (bindingResult.hasErrors()) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        User user = (User) authentication.getPrincipal();
        problemResult.setUserId(user.getId());
        return producer.send(problemResult);
    }


}
