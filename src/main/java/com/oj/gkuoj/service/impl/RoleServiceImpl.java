package com.oj.gkuoj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.dao.RoleMapper;
import com.oj.gkuoj.entity.Role;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public RestResponseVO getById(Integer roleId) {
        Role role = roleMapper.selectByPrimaryKey(roleId);
        return RestResponseVO.createBySuccess(role);
    }

    @Override
    public RestResponseVO insert(Role role) {
        if(role == null){
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = roleMapper.insertSelective(role);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public RestResponseVO delById(Integer id) {
        if(id == null){
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = roleMapper.deleteByPrimaryKey(id);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public RestResponseVO updateById(Role role) {
        if(role == null){
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = roleMapper.updateByPrimaryKeySelective(role);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.UPDATE_FAIL);
    }

    @Override
    public RestResponseVO<PageInfo> listRole2Page(Integer pageNum, Integer pageSize,String keyword) {
        if(pageNum == null || pageSize == null){
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        PageHelper.startPage(pageNum,pageSize,true);
        List<Role> roleList = roleMapper.listRoleByKeyWord(keyword);
        PageInfo<Role> pageInfo = new PageInfo<Role>(roleList);
        return RestResponseVO.createBySuccess(pageInfo);
    }

    @Override
    public RestResponseVO listRole() {
     return RestResponseVO.createBySuccess(roleMapper.listRole());
    }

}
