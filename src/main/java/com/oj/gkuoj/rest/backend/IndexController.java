package com.oj.gkuoj.rest.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author m969130721@163.com
 * @date 19-2-18 下午8:26
 */
@Controller("backendIndexController")
@RequestMapping("/backend")
public class IndexController {


    @RequestMapping("/")
    public String index() {
       return "backend/index";

    }


}
