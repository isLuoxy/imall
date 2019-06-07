package com.luo.imall.web.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author L99
 * @createDate 2019/6/6
 *
 */
@Slf4j
public class LoginUtil {

    /**
     * 登陆状态验证
     * @param request
     * @return
     */
    public static boolean validateStatus(HttpServletRequest request) {
        Object authentication = request.getAttribute("authentication");

        log.info("getCart: {}", authentication);

        if (authentication == null) {
            return true;
        }
        return false;
    }
}
