package com.oj.gkuoj.config;

import com.oj.gkuoj.common.RestResponseEnum;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author m969130721@163.com
 * @date 19-1-16 上午12:47
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(LoginFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        logger.info("登录失败,exception:{}",e.getMessage());
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        RestResponseVO<Object> response = RestResponseVO.createByErrorMessage(e.getLocalizedMessage());
        String responseStr = JsonUtil.obj2String(response);
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(responseStr);
        writer.flush();
        writer.close();
    }
}
