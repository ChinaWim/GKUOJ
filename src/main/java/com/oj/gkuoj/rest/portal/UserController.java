package com.oj.gkuoj.rest.portal;

import com.oj.gkuoj.common.ExceptionStatusConst;
import com.oj.gkuoj.entity.Blog;
import com.oj.gkuoj.entity.Problem;
import com.oj.gkuoj.request.UserRequest;
import com.oj.gkuoj.response.ProblemResultRecentVO;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.exception.UserNotFoundException;
import com.oj.gkuoj.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-30 下午3:12
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    private static final Integer RECENT_BLOG_SIZE = 5;

    private static final Integer RECENT_PROBLEM_RESULT_SIZE = 5;

    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping("/loginPage")
    public String loginPage() {
        return "portal/login";
    }

    /**
     * 用户注册页面
     *
     * @return
     */
    @RequestMapping("/registerPage")
    public String registerPage() {
        return "portal/register";
    }

    /**
     * 忘记密码页面
     *
     * @return
     */
    @RequestMapping("/forgetPage")
    public String forgetPage() {
        return "portal/forget";
    }


    /**
     * 注册提交页面
     *
     * @return
     */
    @RequestMapping("/registerSubmitPage")
    public String registerSubmitPage(String token, String email, HttpServletRequest request) {
        request.setAttribute("token", token);
        request.setAttribute("email", email);
        return "portal/registerSubmit";
    }

    /**
     * 忘记密码提交修改页面
     *
     * @return
     */
    @RequestMapping("/forgetSubmitPage")
    public String forgetSubmitPage(String token, String email, HttpServletRequest request) {
        request.setAttribute("token", token);
        request.setAttribute("email", email);
        return "portal/forgetSubmit";
    }


    /**
     * 发送注册邮件
     *
     * @param email
     * @return
     */
    @RequestMapping("/sendRegisterEmail")
    @ResponseBody
    public RestResponseVO sendRegisterEmail(String email) {
        return userService.sendRegisterEmail(email);
    }

    /**
     * 发送忘记密码验证邮件
     *
     * @param email
     * @return
     */
    @RequestMapping("/sendForgetEmail")
    @ResponseBody
    public RestResponseVO sendForgetEmail(String email) {
        return userService.sendForgetEmail(email);
    }


    /**
     * 忘记密码提交修改
     *
     * @param token
     * @param password
     * @param email
     * @return
     */
    @RequestMapping("/forgetSubmitProcess")
    @ResponseBody
    public RestResponseVO forgetSubmitProcess(String token, String email, String password) {
        return userService.forgetRestPassword(token, email, password);
    }


    /**
     * 提交注册
     *
     * @param token
     * @param request
     * @return
     */
    @RequestMapping("/registerSubmitProcess")
    @ResponseBody
    public RestResponseVO registerSubmitProcess(String token, UserRequest request) {
        return userService.register(token, request);
    }


    /**
     * 用户主页
     *
     * @return
     */
    @RequestMapping("/mainPage")
    public String mainPage(Integer userId, HttpServletRequest request) {
        RestResponseVO response = userService.getById(userId);
        if (response.isSuccess() && response.getData() != null) {
            List<Problem> problemList = userService.listAllSolveProblemByUserId(userId).getData();
            List<Blog> blogList = userService.listRecentBlog(userId,RECENT_BLOG_SIZE).getData();
            List<ProblemResultRecentVO> problemResultList = userService.listRecentProblem(userId, RECENT_PROBLEM_RESULT_SIZE).getData();

            request.setAttribute("user", response.getData());
            request.setAttribute("solveProblemList", problemList);
            request.setAttribute("blogList", blogList);
            request.setAttribute("problemResultList", problemResultList);
        } else {
            throw new UserNotFoundException(ExceptionStatusConst.USER_NOT_FOUND_EXP, "用户未找到");
        }
        return "portal/user/main";
    }

    /**
     * 个人信息修改页面
     *
     * @return
     */
    @RequestMapping("/profilePage")
    @PreAuthorize("authentication.name.equals(#username)")//只能操作自己
    public String profilePage() {
        return "portal/user/profile";
    }

}
