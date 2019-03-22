package com.oj.gkuoj.rest.backend;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.entity.BlogCategory;
import com.oj.gkuoj.entity.Role;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.BlogCategoryService;
import com.oj.gkuoj.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author m969130721@163.com
 * @date 19-3-10 下午4:21
 */

@Controller("backendBlogCategoryController")
@RequestMapping("/backend/blogCategory")
public class BlogCategoryController {


    @Autowired
    private BlogCategoryService blogCategoryService;


    /**
     * 跳转到博客分类列表页面
     *
     * @return
     */
    @RequestMapping("/blogCategoryListPage")
    public String userListPage(HttpServletRequest request) {
        request.setAttribute("blogManageActive",true);
        request.setAttribute("blogCategoryActive",true);
        return "backend/blog/blog-category-list";
    }


    /**
     * 获取分类到页面
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/listBlogCategory2Page")
    @ResponseBody
    public RestResponseVO<PageInfo> listBlogCategory2Page(@RequestParam(defaultValue = "1") Integer pageNum,
                                                  @RequestParam(defaultValue = "10")Integer pageSize,
                                                  @RequestParam(defaultValue = "")String keyword){
        return blogCategoryService.listBlogCategory2Page(pageNum,pageSize,keyword);
    }


    /**
     * 添加
     * @param blogCategory
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public RestResponseVO save(BlogCategory blogCategory){
        if(blogCategory != null && blogCategory.getId() != null){
            return blogCategoryService.updateById(blogCategory);
        }else {
            return blogCategoryService.insert(blogCategory);
        }
    }



    /**
     *  get
     * @param blogCategoryId
     * @return
     */
    @RequestMapping("/get")
    @ResponseBody
    public RestResponseVO get(Integer blogCategoryId){
        return blogCategoryService.getById(blogCategoryId);
    }


    /**
     * 删除
     * @param blogCategoryId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public RestResponseVO delete(Integer blogCategoryId){
        return blogCategoryService.delById(blogCategoryId);
    }


    /**
     * 获取全部
     * @param
     * @return
     */
    @RequestMapping("/listAll")
    @ResponseBody
    public RestResponseVO listAll(){
        return blogCategoryService.listAll();
    }



}
