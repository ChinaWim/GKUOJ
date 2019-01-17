package com.oj.gkuoj.config;

import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.utils.JsonUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
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
@Component()
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        RestResponseVO response = RestResponseVO.createBySuccess();
        String responseStr = JsonUtil.obj2String(response);
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(responseStr);
        writer.flush();
        writer.close();
    }
}
