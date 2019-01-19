package com.oj.gkuoj.rest.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author m969130721@163.com
 * @date 19-1-19 下午6:27
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @RequestMapping("/blogListPage")
    public String blogListPage(HttpServletRequest request){
        request.setAttribute("active5",true);
        return "portal/blog/blog-list";
    }


}
