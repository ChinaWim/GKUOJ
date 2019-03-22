package com.oj.gkuoj.rest.backend;

import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.TestcaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author m969130721@163.com
 * @date 19-3-10 下午4:20
 */
@Controller("backendTestcase")
@RequestMapping("/backend/testcase")
public class TestcaseController {

    @Autowired
    TestcaseService testcaseService;

    @RequestMapping("/list2PageByProblemId")
    @ResponseBody
    public RestResponseVO list2PageByProblemId(Integer problemId){
        return testcaseService.listTestcaseByProblemId(problemId);
    }



    /**
     * 跳转到测试用例列表页面
     *
     * @return
     */
    @RequestMapping("/testcaseListPage")
    public String userListPage(HttpServletRequest request) {
        request.setAttribute("questionActive",true);
        request.setAttribute("testcaseActive",true);
        return "backend/testcase/testcase-list";
    }



}
