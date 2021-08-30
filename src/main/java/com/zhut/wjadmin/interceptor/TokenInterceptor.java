package com.zhut.wjadmin.interceptor;

import com.zhut.wjadmin.config.JwtConfig;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SignatureException;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Resource
    private JwtConfig jwtConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();
        if (url.contains("/login")) {
            return true;
        }
        String token = request.getHeader(jwtConfig.getHeader());
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(jwtConfig.getHeader());
        }

        if (StringUtils.isBlank(token)) {
            throw new SignatureException(jwtConfig.getHeader() + "不能为空");
        }

        Claims tokenClaim = null;

        try {
            tokenClaim = jwtConfig.getTokenClaim(token);
            if (tokenClaim == null || jwtConfig.isExpire(tokenClaim.getExpiration())) {
                throw new SignatureException(jwtConfig.getHeader() + "失效，请重新登录。");
            }
        } catch (Exception e) {
//            e.printStackTrace();
            throw new SignatureException(jwtConfig.getHeader() + "失效，请重新登录。");
        }

        request.setAttribute("identityId", tokenClaim.getSubject());

        return true;
    }
}
