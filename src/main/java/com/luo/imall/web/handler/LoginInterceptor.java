package com.luo.imall.web.handler;


import com.luo.imall.web.util.TokenGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

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

        String token = request.getParameter("token");
        String timestamp = request.getParameter("timestamp");
        String sign = request.getParameter("sign");
        String name = stringRedisTemplate.opsForValue().get(token);
        boolean time = System.currentTimeMillis() - Long.parseLong(timestamp) < 3600000;
        if ( name != null &&  time && verifySignature(sign,token,timestamp,token) && stringRedisTemplate.opsForSet().add(timestamp, sign) == 1) {
            stringRedisTemplate.expire(timestamp, 3600, TimeUnit.SECONDS);
            request.setAttribute("authentication",true);
            request.setAttribute("name",name);
        }

        return true;
    }

    /**
     * 判断当前签名是否被修改过
     * @param sign 签名
     * @param strings 生成签名的字符串，token+timestamp+salt
     * @return
     */
    private boolean verifySignature(String sign,String ... strings){
        return sign.equalsIgnoreCase(TokenGenerator.tokenGenerator32(false,strings));
    }
}
