package com.oj.gkuoj.rest.backend;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.entity.Blog;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author m969130721@163.com
 * @date 19-3-10 下午3:29
 */
@Controller("backendBlogController")
@RequestMapping("/backend/blog")
@Slf4j
public class BlogController {

    @Autowired
    private BlogService blogService;

    /**
     * 获取博客到页面
     * @param pageNum
     * @param pageSize
     * @param sort
     * @param keyword
     * @param bcId
     * @return
     */
    @RequestMapping("/list2Page")
    @ResponseBody
    public RestResponseVO<PageInfo> listBlog(@RequestParam(defaultValue = "1")Integer pageNum,
                                             @RequestParam(defaultValue = "20")Integer pageSize,
                                             @RequestParam(defaultValue = "-1") Integer sort,
                                             @RequestParam(defaultValue = "") String keyword,
                                             @RequestParam(defaultValue = "-1") Integer bcId){

        return blogService.listBlogVO2Page(pageNum,pageSize,sort,keyword,bcId);
    }

    /**
     * 增加
     * @param blog
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public RestResponseVO add(Blog blog){
        return blogService.insert(blog);
    }

    /**
     * 删除
     * @param blogId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public RestResponseVO delete(Integer blogId){
        return blogService.delById(blogId);
    }


    /**
     * 更新
     * @param blog
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public RestResponseVO update(Blog blog){
        return blogService.updateById(blog);
    }









}
