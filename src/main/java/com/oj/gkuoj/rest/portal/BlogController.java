package com.oj.gkuoj.rest.portal;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.entity.Blog;
import com.oj.gkuoj.entity.BlogCategory;
import com.oj.gkuoj.entity.User;
import com.oj.gkuoj.response.BlogDetailVO;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.BlogCategoryService;
import com.oj.gkuoj.service.BlogCommentService;
import com.oj.gkuoj.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

/**
 * @author m969130721@163.com
 * @date 19-1-19 下午6:27
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogCategoryService blogCategoryService;

    @Autowired
    private BlogCommentService blogCommentService;


    @RequestMapping("/blogListPage")
    public String blogListPage(HttpServletRequest request,
                               @RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "25") Integer pageSize,
                               @RequestParam(defaultValue = "", required = false) String keyword,
                               @RequestParam(defaultValue = "-1", required = false) Integer bcId) {
        RestResponseVO<PageInfo> responseVO = blogService.listBlogVO2(pageNum, pageSize, keyword, bcId);

        PageInfo pageInfo = responseVO.getData();
        long total = pageInfo.getTotal();
        List blogList = pageInfo.getList();
        RestResponseVO<List<BlogCategory>> blogCategoryResponse = blogCategoryService.listAll();
        List<BlogCategory> blogCategoryList = blogCategoryResponse.getData();

        BlogCategory blogCategory = new BlogCategory();
        blogCategory.setId(-1);
        blogCategory.setName("全部");
        blogCategoryList.add(0,blogCategory);

        //set data
        request.setAttribute("blogList", blogList);
        request.setAttribute("blogCategoryList", blogCategoryList);
        request.setAttribute("total", total);
        request.setAttribute("pageNum",pageNum);
        request.setAttribute("keyword",keyword);
        request.setAttribute("bcId",bcId);
        request.setAttribute("active6", true);
        return "portal/blog/blog-list";
    }

    @RequestMapping("/blogEditPage")
    public String blogEditPage(HttpServletRequest request){
        RestResponseVO<List<BlogCategory>> blogCategoryResponse = blogCategoryService.listAll();
        List<BlogCategory> blogCategoryList = blogCategoryResponse.getData();

        //set data
        request.setAttribute("blogCategoryList", blogCategoryList);
        request.setAttribute("active6", true);
        return "portal/blog/blog-edit";
    }

    @RequestMapping("/blogDetailPage")
    public String blogDetailPage(HttpServletRequest request,
                                 @RequestParam(defaultValue = "1")Integer pageNum,
                                 @RequestParam(defaultValue = "5")Integer pageSize,
                                 @RequestParam(defaultValue = "1",required = false)Integer sort,
                                 Integer blogId){

        //updateBlogViewCount
        blogService.updateViewCount(blogId);

        RestResponseVO<BlogDetailVO> blogResponse = blogService.getBlogDetailVOById(blogId);

        RestResponseVO<PageInfo> pageInfoResponse = blogCommentService.listByBlogId2Page(sort, pageNum, pageSize, blogId);
        PageInfo pageInfo = pageInfoResponse.getData();

        //set data
        if(blogResponse.isSuccess()){
            BlogDetailVO blogDetailVO = blogResponse.getData();
            request.setAttribute("blogDetail",blogDetailVO);
        }
        request.setAttribute("active6", true);
        request.setAttribute("blogCommentList",pageInfo.getList());
        return "portal/blog/blog-detail";
    }


    @RequestMapping("/saveBlog")
    @ResponseBody
    public RestResponseVO saveBlog(Blog blog, @AuthenticationPrincipal UserDetails userDetails){
        if (userDetails  == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.UNAUTHORIZED);
        }
        User user = (User) userDetails;
        blog.setUserId(user.getId());

        return blogService.insert(blog);
    }


}
