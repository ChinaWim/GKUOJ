package com.oj.gkuoj.rest.backend;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.entity.User;
import com.oj.gkuoj.request.UserRequest;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.FileService;
import com.oj.gkuoj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author m969130721@163.com
 * @date 19-2-18 下午9:17
 */
@Controller("backendUserController")
@RequestMapping("/backend/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FileService fileService;

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping("/loginPage")
    public String index() {
        return "backend/login";
    }

    /**
     * 跳转到用户列表页面
     *
     * @return
     */
    @RequestMapping("/userListPage")
    public String userListPage(HttpServletRequest request) {
        request.setAttribute("systemActive",true);
        request.setAttribute("userActive",true);
        return "backend/user/user-list";
    }


    /**
     * 获取用户列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/listUser2Page")
    @ResponseBody
    public RestResponseVO<PageInfo> listUser2Page(@RequestParam(defaultValue = "1") Integer pageNum,
                                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                                  @RequestParam(defaultValue = "") String keyword) {
        return userService.listUser2Page(pageNum, pageSize, keyword);
    }


    /**
     * 添加-更新用户
     *
     * @param request
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public RestResponseVO save(UserRequest request, @RequestParam(required = false) MultipartFile file) {
        if (file != null) {
            RestResponseVO<String> uploadImage = fileService.uploadImage(file,request.getUsername());
            if(uploadImage.isSuccess()){
                request.setAvatar(uploadImage.getData());
            }
        }
        if (request.getId() == null) {
            return userService.insert(request);
        } else {
            return userService.updateById(request);
        }
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public RestResponseVO delete(Integer userId) {
        return userService.delById(userId);
    }


    /**
     * 冻结用户
     *
     * @param userId
     * @return
     */
    @RequestMapping("/lock")
    @ResponseBody
    public RestResponseVO lock(Integer userId) {
        return userService.lockById(userId);
    }


    /**
     * 激活用户
     *
     * @param userId
     * @return
     */
    @RequestMapping("/active")
    @ResponseBody
    public RestResponseVO active(Integer userId) {
        return userService.activeById(userId);
    }


    /**
     * 更新用户
     *
     * @param request
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public RestResponseVO update(UserRequest request) {
        return userService.updateById(request);
    }


    /**
     * 获取用户
     *
     * @param userId
     * @return
     */
    @RequestMapping("/get")
    @ResponseBody
    public RestResponseVO get(Integer userId) {
        return userService.getById(userId);
    }


}
