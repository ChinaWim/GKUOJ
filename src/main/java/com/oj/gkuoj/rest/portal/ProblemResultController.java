package com.oj.gkuoj.rest.portal;

import com.oj.gkuoj.response.ServerResponseVO;
import com.oj.gkuoj.entity.ProblemResult;
import com.oj.gkuoj.service.ProblemResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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


    /**
     * 测评记录列表页面
     * @param request
     * @return
     */
    @RequestMapping("/problemResultListPage")
    public String problemResultListPage(HttpServletRequest request){
        //set data
        request.setAttribute("active5",true);
        return "portal/problemResult/problemResult-list";
    }


    /**
     * 显示源码
     * @param request
     * @param problemResultId
     * @return
     */
    @RequestMapping("/showSourceCodePage")
    public String showSourceCodePage(HttpServletRequest request,Integer problemResultId){

        //set data
        ServerResponseVO<ProblemResult> serverResponse = problemResultService.getById(problemResultId);
        if(serverResponse.isSuccess()){
            request.setAttribute("sourceCode",serverResponse.getData().getSourceCode());
        }else {
            request.setAttribute("sourceCode",serverResponse.getMsg());
        }
        return "portal/problemResult/source-code";
    }






}
