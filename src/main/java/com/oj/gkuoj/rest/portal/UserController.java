package com.oj.gkuoj.rest.portal;

import com.oj.gkuoj.common.ExceptionStatusConst;
import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.exception.UserNotFoundException;
import com.oj.gkuoj.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping("/loginPage")
    public String loginPage(){
        return "portal/login";
    }


    /**
     * 登录错误处理
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
    @RequestMapping("/registerPage")
    public String registerPage(){
        return "portal/register";
    }


    /**
     * 用户主页
     * @return
     */
    @RequestMapping("/mainPage")
    public String mainPage(Integer userId,HttpServletRequest request){
        RestResponseVO response = userService.getById(userId);
        if (response.isSuccess() && response.getData() != null){
            request.setAttribute("user",response.getData());
        }else {
            throw new UserNotFoundException(ExceptionStatusConst.USER_NOT_FOUND_EXP,"用户未找到");
        }
        return "portal/user/main";
    }

    /**
     * 个人信息修改页面
     * @return
     */
    @RequestMapping("/profilePage")
    @PreAuthorize("authentication.name.equals(#username)")//只能操作自己
    public String profilePage(){
        return "portal/user/profile";
    }


    @RequestMapping("/sendEmail")
    @ResponseBody
    public RestResponseVO sendEmail(String email){
        return userService.sendEmail(email);
    }


}
