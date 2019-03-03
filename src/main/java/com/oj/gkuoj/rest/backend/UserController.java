package com.oj.gkuoj.rest.backend;

import com.oj.gkuoj.entity.User;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author m969130721@163.com
 * @date 19-2-18 下午9:17
 */
@Controller("backendUserController")
@RequestMapping("/backend/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/loginPage")
    public String index() {
        System.out.println("asda");
        return "backend/login";
    }

   /* @RequestMapping("/loginProcess")
    public RestResponseVO login(String username, String password) {
        return userService.checkLoginByAdmin(username, password);
    }*/


}
