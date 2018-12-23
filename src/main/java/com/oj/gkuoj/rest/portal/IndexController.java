package com.oj.gkuoj.rest.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午12:42
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        request.setAttribute("active1",true);
        return "index";
    }

}
