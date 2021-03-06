package com.oj.gkuoj.rest.portal;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.entity.Blog;
import com.oj.gkuoj.entity.BlogCategory;
import com.oj.gkuoj.entity.BlogComment;
import com.oj.gkuoj.entity.User;
import com.oj.gkuoj.response.BlogDetailVO;
import com.oj.gkuoj.response.BlogVO;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.BlogCategoryService;
import com.oj.gkuoj.service.BlogCommentService;
import com.oj.gkuoj.service.BlogService;
import com.oj.gkuoj.service.UpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import java.util.Iterator;
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

    private final Integer SIZE_HOT_BLOG = 10;

    /**
     * 跳转到博客首页
     *
     * @param request
     * @return
     */
    @RequestMapping("/blogListPage")
    public String blogListPage(HttpServletRequest request,
                               @RequestParam(defaultValue = "-1") Integer bcId,
                               @RequestParam(defaultValue = "") String keyword) {

        //分类
        RestResponseVO<List<BlogCategory>> blogCategoryResponse = blogCategoryService.listAll();
        List<BlogCategory> blogCategoryList = blogCategoryResponse.getData();
        BlogCategory blogCategory = new BlogCategory();
        blogCategory.setId(-1);
        blogCategory.setName("全部");
        blogCategoryList.add(0, blogCategory);

        //近期热帖
        RestResponseVO<List<BlogVO>> hotBlogVO = blogService.listHotBlogVO(SIZE_HOT_BLOG);
        List<BlogVO> hotBlogList = hotBlogVO.getData();


        //热门标签 todo

        //set data
        request.setAttribute("bcId", bcId);
        request.setAttribute("keyword", keyword);
        request.setAttribute("hotBlogList", hotBlogList);
        request.setAttribute("blogCategoryList", blogCategoryList);
        request.setAttribute("active6", true);
        return "portal/blog/blog-list";
    }

    /**
     * 博客list
     *
     * @param pageNum
     * @param pageSize
     * @param sort     1date desc　２点赞 desc
     * @param keyword
     * @param bcId
     * @return
     */
    @RequestMapping("/listBlog2Page")
    @ResponseBody
    public RestResponseVO<PageInfo> listBlog2Page(@RequestParam(defaultValue = "1") Integer pageNum,
                                                  @RequestParam(defaultValue = "20") Integer pageSize,
                                                  @RequestParam(defaultValue = "-1") Integer sort,
                                                  @RequestParam(defaultValue = "", required = false) String keyword,
                                                  @RequestParam(defaultValue = "-1", required = false) Integer bcId) {
        return blogService.listBlogVO2Page(pageNum, pageSize, sort, keyword, bcId);
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

        //去掉公告
        blogCategoryList.remove(0);

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

        //近期热帖
        RestResponseVO<List<BlogVO>> hotBlogVO = blogService.listHotBlogVO(SIZE_HOT_BLOG);
        List<BlogVO> hotBlogList = hotBlogVO.getData();


        //set data
        if (blogResponse.isSuccess()) {
            BlogDetailVO blogDetailVO = blogResponse.getData();
            request.setAttribute("blogDetail", blogDetailVO);
        }
        request.setAttribute("hotBlogList", hotBlogList);
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
