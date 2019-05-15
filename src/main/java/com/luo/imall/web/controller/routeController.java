package com.luo.imall.web.controller;

import com.luo.imall.web.constant.TokenConstant;
import com.luo.imall.web.service.IUmsMemberService;
import com.luo.imall.web.util.CookieUtil;
import com.luo.imall.web.util.TokenGenerator;
import com.luo.imall.web.vo.CommonResult;
import com.luo.imall.web.vo.CreateUmsMemberRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author L99
 * @createDate 2019/5/13
 *
 */
@Controller
@Slf4j
public class routeController {


    @GetMapping("/index")
    public String index() {
        log.info("进入index方法");
        return "index";
    }

    @GetMapping("/test")
    public String test() {
        log.info("进入test方法");
        return "test";
    }

    @GetMapping("/json")
    @ResponseBody
    public void json(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("进入 json 方法");
        request.getRequestDispatcher("/test").forward(request, response);
    }


    @Autowired
    IUmsMemberService memberService;

    @Autowired
    HttpServletRequest servletRequest;

    @Autowired
    StringRedisTemplate redisTemplate;

    @PostMapping("/loginTest")
    public void loginTest(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletResponse response) throws Exception {

        log.info("login: {},{}", username, password);

        String returnUrl = servletRequest.getParameter("returnUrl");
        log.info("RequestURI: {}", servletRequest.getRequestURI());
        log.info("RequestURL: {}", servletRequest.getRequestURL().toString());
        log.info("returnUrl: {}", returnUrl);
        CreateUmsMemberRequest createUmsMemberRequest = new CreateUmsMemberRequest();
        createUmsMemberRequest.setUsername(username);
        createUmsMemberRequest.setPassword(password);
        CommonResult result = memberService.validateLogin(createUmsMemberRequest);
        if (result.getErrorCode() == 0) {
            // 说明登陆成功，那么保存用户登陆状态

            // 获取客户端 ip
            String ip = servletRequest.getRemoteAddr();

            // MD5(用户名+密码+客户端ip+时间戳)
            String tokenValue = TokenGenerator.tokenGenerator32(true, createUmsMemberRequest.getUsername(), createUmsMemberRequest.getPassword(), ip);

            // 设置 redis 值，｛tokenValue:ip｝，添加过期时间
            redisTemplate.opsForValue().set(tokenValue, ip);

            // 设置 cookie
            CookieUtil.set(response, TokenConstant.TOKEN, tokenValue, TokenConstant.TOKEN_EXPIRE_TIME);

            returnUrl = returnUrl == "" ? servletRequest.getContextPath() + "/index" : returnUrl;
            log.info("after returnUrl: {}", returnUrl);
            response.sendRedirect(returnUrl);

            return;
        }
        response.sendRedirect(servletRequest.getContextPath() + "/login");
    }

}
