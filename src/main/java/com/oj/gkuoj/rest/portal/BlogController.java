package com.oj.gkuoj.rest.portal;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.entity.Blog;
import com.oj.gkuoj.entity.BlogCategory;
import com.oj.gkuoj.entity.BlogComment;
import com.oj.gkuoj.entity.User;
import com.oj.gkuoj.response.BlogDetailVO;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.BlogCategoryService;
import com.oj.gkuoj.service.BlogCommentService;
import com.oj.gkuoj.service.BlogService;
import com.oj.gkuoj.service.UpService;
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

    @Autowired
    private UpService upService;

    /**
     * 跳转到博客首页
     *
     * @param request
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @param bcId
     * @return
     */
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
        blogCategoryList.add(0, blogCategory);

        //set data
        request.setAttribute("blogList", blogList);
        request.setAttribute("blogCategoryList", blogCategoryList);
        request.setAttribute("total", total);
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("keyword", keyword);
        request.setAttribute("bcId", bcId);
        request.setAttribute("active6", true);
        return "portal/blog/blog-list";
    }

    /**
     * 跳转到博客编辑页面
     *
     * @param request
     * @return
     */
    @RequestMapping("/blogEditPage")
    public String blogEditPage(HttpServletRequest request) {
        RestResponseVO<List<BlogCategory>> blogCategoryResponse = blogCategoryService.listAll();
        List<BlogCategory> blogCategoryList = blogCategoryResponse.getData();

        //set data
        request.setAttribute("blogCategoryList", blogCategoryList);
        request.setAttribute("active6", true);
        return "portal/blog/blog-edit";
    }


    /**
     * 跳转到博客详情页面
     *
     * @param request
     * @param pageNum
     * @param pageSize
     * @param sort
     * @param blogId
     * @return
     */
    @RequestMapping("/blogDetailPage")
    public String blogDetailPage(HttpServletRequest request,
                                 @RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "5") Integer pageSize,
                                 @RequestParam(defaultValue = "1", required = false) Integer sort,
                                 Integer blogId,
                                 @AuthenticationPrincipal UserDetails userDetails) {

        //updateBlogViewCount
        blogService.updateViewCount(blogId);
        Integer userId = null;
        if (userDetails != null) {
            userId = ((User) userDetails).getId();
        }
        RestResponseVO<BlogDetailVO> blogResponse = blogService.getBlogDetailVOById(blogId, userId);

        //set data
        if (blogResponse.isSuccess()) {
            BlogDetailVO blogDetailVO = blogResponse.getData();
            request.setAttribute("blogDetail", blogDetailVO);
        }
        request.setAttribute("active6", true);
        return "portal/blog/blog-detail";
    }


    /**
     * 保存博客
     *
     * @param blog
     * @param userDetails
     * @return
     */
    @PostMapping("/saveBlog")
    @ResponseBody
    public RestResponseVO saveBlog(Blog blog, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.UNAUTHORIZED);
        }
        User user = (User) userDetails;
        blog.setUserId(user.getId());

        return blogService.insert(blog);
    }

    /**
     * 　博客点赞
     *
     * @param blogId
     * @param userDetails
     * @return
     */
    @RequestMapping("/blogUp")
    @ResponseBody
    public RestResponseVO blogUp(Integer blogId, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.UNAUTHORIZED);
        }
        User user = (User) userDetails;
        return upService.blogUp(blogId, user.getId());
    }

    /**
     * 提交博客评论
     *
     * @param blogComment
     * @param userDetails
     * @return
     */
    @PostMapping("/saveBlogComment")
    @ResponseBody
    public RestResponseVO saveBlogComment(BlogComment blogComment, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.UNAUTHORIZED);
        }
        User user = (User) userDetails;
        blogComment.setUserId(user.getId());

        return blogCommentService.insert(blogComment);
    }


}
