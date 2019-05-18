package com.luo.imall.web.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户状态判断工具类
 * @author L99
 * @createDate 2019/5/17
 *
 */
public class UserStatusUtil {

    /**
     * 返回用户是否已经登陆，true 为登陆，反之未登录
     * @param request
     * @return
     */
    public static final boolean isLogin(HttpServletRequest request) {

        return request.getAttribute("authentication") != null;
    }

    public static final void setLogin(){

    }
}
