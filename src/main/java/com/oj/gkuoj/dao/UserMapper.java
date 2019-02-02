package com.oj.gkuoj.dao;

import com.oj.gkuoj.entity.User;
import com.oj.gkuoj.response.RankVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int addSignCount(Integer userId);

    User getByUserName(String username);

    int countByEmail(String email);

    int resetPasswordByEmail(@Param("email") String email, @Param("password") String password);

    List<RankVO> listRankUser(@Param("keyword") String keyword);

}