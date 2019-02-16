package com.oj.gkuoj.service;

import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.entity.Register;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午4:29
 */
public interface RegisterService {

    RestResponseVO insert(Register register);

    RestResponseVO delById(Integer id);

    RestResponseVO updateById(Register register);

    RestResponseVO registerCompetition(Integer userId,Integer compId,String password);

    RestResponseVO isRegisterCompetition(Integer userId, Integer compId);


    RestResponseVO<PageInfo> listRegisterByCompId2Page(Integer compId, Integer pageNum, Integer pageSize);



}
