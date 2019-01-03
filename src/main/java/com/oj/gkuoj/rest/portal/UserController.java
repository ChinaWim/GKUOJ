package com.oj.gkuoj.rest.portal;

import com.oj.gkuoj.entity.User;
import com.oj.gkuoj.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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

    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "portal/login";
    }


    /**
     * 登录错误
     */

    @RequestMapping("/loginError")
    public String loginError(HttpServletRequest request){
        request.setAttribute("msg","账号或密码错误");
        logger.info("账号或密码错误");
        return "portal/login";
    }


    /**
     * 用户注册页面
     * @return
     */
    @RequestMapping("/register")
    public String register(){
        return "portal/register";
    }



}
