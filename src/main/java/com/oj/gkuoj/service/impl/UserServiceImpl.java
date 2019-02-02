package com.oj.gkuoj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.response.RankVO;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.common.StringConst;
import com.oj.gkuoj.dao.RoleMapper;
import com.oj.gkuoj.dao.UserMapper;
import com.oj.gkuoj.dao.UserRoleMapper;
import com.oj.gkuoj.service.UserService;
import com.oj.gkuoj.entity.User;
import com.oj.gkuoj.utils.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:45
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String mailUsername;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public RestResponseVO addSignCount(Integer userId) {
        if (userId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = userMapper.addSignCount(userId);
        return effect > 0 ? RestResponseVO.createBySuccess() : RestResponseVO.createByError();
    }

    @Override
    public RestResponseVO<User> getById(Integer userId) {
        if (userId == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        User user = userMapper.selectByPrimaryKey(userId);
        return RestResponseVO.createBySuccess(user);
    }

    @Override
    public RestResponseVO insert(User user) {
        if (user == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = userMapper.insertSelective(user);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public RestResponseVO delById(Integer id) {
        if (id == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = userMapper.deleteByPrimaryKey(id);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public RestResponseVO update(User user) {
        if (user == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = userMapper.updateByPrimaryKeySelective(user);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.UPDATE_FAIL);
    }

    @Override
    public RestResponseVO sendRegisterEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }

        int effect = userMapper.countByEmail(email);
        if (effect > 0) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.EMAIL_REPEATED_ERROR);
        }
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            //send email todo into redis
            String token = UUIDUtil.createByAPI32();
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(mailUsername);
            helper.setTo(email);
            helper.setSubject("【计算机程序在线性能测评系统】邮箱验证");
            String html = StringConst.getRegisterEmailContent("123");
            helper.setText(html, true);
            javaMailSender.send(message);
            return RestResponseVO.createBySuccess();
        } catch (Exception e) {
            logger.error("邮箱发送异常,{}", e.getMessage());
            return RestResponseVO.createByErrorEnum(RestResponseEnum.EMAIL_SEND_ERROR);
        }
    }


    @Override
    public RestResponseVO sendForgetEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        int effect = userMapper.countByEmail(email);
        if (effect == 0) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.EMAIL_NOT_FOUND_ERROR);
        }
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            //send email todo into redis
            String token = UUIDUtil.createByAPI32();
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(mailUsername);
            helper.setTo(email);
            helper.setSubject("【计算机程序在线性能测评系统】重设密码");
            String html = StringConst.getForgetPasswordEmailContent("123");
            helper.setText(html, true);
            javaMailSender.send(message);
            return RestResponseVO.createBySuccess();
        } catch (Exception e) {
            logger.error("邮箱发送异常,{}", e.getMessage());
            return RestResponseVO.createByErrorEnum(RestResponseEnum.EMAIL_SEND_ERROR);
        }
    }

    @Override
    public RestResponseVO forgetRestPassword(String token, String password) {
        //todo
        if (!StringUtils.isNoneBlank(token, password)) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        //从token中获取，更新成功后remove token
        String email = "";
        String encodePassword = passwordEncoder.encode(password);
        int effect = userMapper.resetPasswordByEmail(email, encodePassword);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.UPDATE_SUCCESS) :
                RestResponseVO.createByErrorMessage(StringConst.UPDATE_FAIL);
    }

    @Override
    public RestResponseVO register(String token, User user) {
        //todo
        if(user == null || StringUtils.isBlank(token)){
            return RestResponseVO.createByErrorEnum(RestResponseEnum.INVALID_REQUEST);
        }
        //判断token，更新成功后remove token
        user.setUsername("");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        int effect = userMapper.insertSelective(user);

        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.ADD_SUCCESS) :
                RestResponseVO.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public RestResponseVO<PageInfo> listRankUser2Page(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum,pageSize,true);
        List<RankVO> userList = userMapper.listRankUser(keyword);
        PageInfo<RankVO> pageInfo = new PageInfo<>(userList);
        return RestResponseVO.createBySuccess(pageInfo);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        System.out.println(user);
        return user;
    }
}
