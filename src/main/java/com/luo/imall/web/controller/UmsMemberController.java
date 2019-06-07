package com.luo.imall.web.controller;

import com.luo.imall.web.constant.TokenConstant;
import com.luo.imall.web.service.IUmsMemberService;

import com.luo.imall.web.vo.CommonResult;
import com.luo.imall.web.vo.CreateUmsMemberRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 会员注册登陆控制类
 * @author L99
 * @createDate 2019/5/12
 *
 */
@Controller
@Slf4j
public class UmsMemberController {

    @Autowired
    private IUmsMemberService memberService;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    HttpServletRequest servletRequest;


    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestBody CreateUmsMemberRequest request) {
        log.info("login: {}", request);
        CommonResult result = memberService.validateLogin(request);
        if (result.getErrorCode() == 0) {
            // 说明登陆成功，那么保存用户登陆状态

            String tokenValue = UUID.randomUUID().toString();
            // 设置 redis 值，｛tokenValue:username｝，添加过期时间
            redisTemplate.opsForValue().set(tokenValue, request.getUsername(), TokenConstant.TOKEN_EXPIRE_TIME, TimeUnit.SECONDS);

            Map<String, Object> token = new HashMap<>(16);
            token.put("token", tokenValue);

            result.setData(token);
        }
        return result;
    }

    @PostMapping("/verify")
    @ResponseBody
    public Object verify(@RequestBody CreateUmsMemberRequest request) {
        log.info("verify: {}", request);
        return memberService.validateUserName(request);
    }

    @PostMapping("/register")
    @ResponseBody
    public Object register(@RequestBody CreateUmsMemberRequest request) {
        log.info("register: {}", request);
        return memberService.validateRegister(request);
    }

}
