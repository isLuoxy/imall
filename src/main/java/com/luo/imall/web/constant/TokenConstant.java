package com.luo.imall.web.constant;

/**
 *
 * @author L99
 * @createDate 2019/5/12
 *
 */
public class TokenConstant {

    /**
     *  设置 Token 过期时间
     */
    public static final Integer TOKEN_EXPIRE_TIME = 21600;

    /**
     * 设置时间戳验证时间，默认为5分钟
     */
    public static final Integer TIMESTAMP_VALID_TIME = 300;

    /**
     * cookie 键
     */
    public static final String TOKEN="token";

}
