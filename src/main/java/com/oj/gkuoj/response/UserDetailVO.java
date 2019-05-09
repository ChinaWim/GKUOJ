package com.oj.gkuoj.response;

import com.oj.gkuoj.entity.Role;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author m969130721@163.com
 * @date 19-3-17 下午2:30
 */
@Data
public class UserDetailVO implements Serializable {

    private static final long serialVersionUID = -2154415380064949390L;

    private Integer id;

    private String username;

    private String password;

    private String name;

    private String mood;

    private String avatar;

    private Integer flag;

    private String sex;

    private String email;

    private String phone;

    private String school;

    private Integer signCount;

    private Integer submitCount;

    private Integer solutionCount;

    private Integer acCount;

    private Integer tleCount;

    private Integer peCount;

    private Integer meCount;

    private Integer ceCount;

    private Integer reCount;

    private Integer waCount;

    private Integer goldCount;

    private Integer rating;

    private Integer competitionCount;

    private Date lastLoginTime;

    private Date createTime;

    private Date updateTime;

    private List<Role> roleList = new ArrayList<>();

    private String roleIds;


}
