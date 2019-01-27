package com.oj.gkuoj.rest.portal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午12:42
 */
@Controller
public class IndexController {
    /**
     * 首页
     * @param request
     * @return
     */
    @RequestMapping("/")
    public String index(HttpServletRequest request){
        //set data
        request.setAttribute("nowDate",new Date());
        request.setAttribute("active1",true);
        return "index";
    }

}
