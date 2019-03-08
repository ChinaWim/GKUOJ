package com.oj.gkuoj.rest.backend;

import com.oj.gkuoj.entity.User;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author m969130721@163.com
 * @date 19-2-18 下午9:17
 */
@Controller("backendUserController")
@RequestMapping("/backend/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/loginPage")
    public String index() {
        return "backend/login";
    }


    /**
     * 显示用户列表
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/listUser2Page")
    @ResponseBody
    public RestResponseVO listUser2Page(@RequestParam(defaultValue = "1") Integer page, @RequestParam("20") Integer size) {
        return userService.listUser2Page(page,size);
    }


    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public RestResponseVO add(User user){
        return userService.insert(user);
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public RestResponseVO delete(Integer userId){
        return userService.delById(userId);
    }


    /**
     * 更新用户
     * @param user
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public RestResponseVO update(User user){
        return userService.updateById(user);
    }







}
