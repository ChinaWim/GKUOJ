package com.oj.gkuoj.rest.portal;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午12:42
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;


    /**
     * 首页
     *
     * @param request
     * @return
     */
    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        //set data
        request.setAttribute("nowDate", new Date());
        request.setAttribute("active1", true);
        return "portal/index";
    }

    /**
     * 排行榜
     * @param request
     * @return
     */
    @RequestMapping("/rankPage")
    public String rankPage(HttpServletRequest request) {

        //set data
        request.setAttribute("active5", true);
        return "portal/rank";
    }

    @RequestMapping("/listRank2Page")
    @ResponseBody
    public RestResponseVO<PageInfo> listRank2Page(@RequestParam(defaultValue = "1")Integer pageNum,
                                                  @RequestParam(defaultValue = "20")Integer pageSize,
                                                  @RequestParam(defaultValue = "",required = false)String keyword){

        return userService.listRankUser2Page(pageNum,pageSize,keyword);
    }


}
