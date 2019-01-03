package com.oj.gkuoj.config.filter;

import com.oj.gkuoj.common.AddressConst;
import com.oj.gkuoj.common.SessionKeyConst;
import com.oj.gkuoj.dto.ImageCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author m969130721@163.com
 * @date 19-1-2 下午8:43
 */
public class ValidateCodeFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(ValidateCodeFilter.class);

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (StringUtils.equals(request.getRequestURI(), AddressConst.LOGIN_PROCESS_URI) &&
                request.getMethod().equalsIgnoreCase("post")) {
            try {
                validate(new ServletWebRequest(request));
            } catch (Exception e) {
                logger.error(e.getMessage());
                request.setAttribute("errorMsg",e.getMessage());
                request.getServletContext().getRequestDispatcher(AddressConst.LOGIN_PAGE_URI).forward(request,response);
                return;
            }
        }

        filterChain.doFilter(request, response);

    }


    private void validate(ServletWebRequest request) {
        String imageCodeParam = request.getParameter("imageCode");
        ImageCode imageCode = (ImageCode) sessionStrategy.getAttribute(request, SessionKeyConst.IMAGE_CODE);
        if (imageCode == null) {
            throw new RuntimeException("验证码不存在");
        }
        if (StringUtils.isBlank(imageCode.getCode())) {
            throw new RuntimeException("验证码不为空");
        }
        if (LocalDateTime.now().isAfter(imageCode.getExpireTime())) {
            throw new RuntimeException("验证码已过期");
        }
        if (!StringUtils.equals(imageCodeParam, imageCode.getCode())) {
            throw new RuntimeException("验证码不匹配");
        }
    }
}
