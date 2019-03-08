package com.oj.gkuoj.rest.backend;


import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.entity.Role;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("backendRoleController")
@RequestMapping("/backend/role")
public class RoleController {

    @Autowired
    RoleService roleService;


    /**
     * 获取角色到页面
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/listRole2Page")
    @ResponseBody
    public RestResponseVO<PageInfo> listRole2Page(Integer pageNum,Integer pageSize){
        return roleService.listRole2Page(pageNum,pageSize);
    }


    /**
     * 添加role
     * @param role
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public RestResponseVO add(Role role){
        return roleService.insert(role);
    }


    /**
     * 更新role
     * @param role
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public RestResponseVO update(Role role){
        return roleService.updateById(role);
    }

    /**
     * 删除role
     * @param roleId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public RestResponseVO delete(Integer roleId){
        return roleService.delById(roleId);
    }





}
