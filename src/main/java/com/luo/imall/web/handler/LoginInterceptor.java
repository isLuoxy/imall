package com.luo.imall.web.handler;

import com.luo.imall.web.constant.TokenConstant;
import com.luo.imall.web.util.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author L99
 * @createDate 2019/5/12
 *
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("======== 进入拦截器 pre ============");
        log.info(request.getRequestURI());
        Cookie token = CookieUtil.get(request, TokenConstant.TOKEN);
        if (token != null) {
            //如果一小时内有响应，则延长登陆状态
            if (stringRedisTemplate.getExpire(token.getValue(), TimeUnit.SECONDS) < 3600) {
                stringRedisTemplate.expire(token.getValue(), TokenConstant.TOKEN_EXPIRE_TIME, TimeUnit.SECONDS);
                token.setMaxAge(TokenConstant.TOKEN_EXPIRE_TIME);
                response.addCookie(token);
            }
            return true;
        } else {
            StringBuffer requestURL = request.getRequestURL();
            String rerutnUrl = requestURL.toString();
            String redirectUrl = request.getContextPath() + "/login?ReturnUrl=" + rerutnUrl;
            response.sendRedirect(redirectUrl);
            return false;
        }
    }
}
