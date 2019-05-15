package com.luo.imall.web.util;

import org.springframework.util.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author L99
 * @createDate 2019/5/12
 *
 */
public class TokenGenerator {

    /**
     * 根据传进来的字符串+时间戳生成32位的Token
     * @param addTimestamp 是否加上时间戳
     * @param Strings
     * @return String
     */
    public static String tokenGenerator32(boolean addTimestamp, String... Strings) {
        long timestamp = System.currentTimeMillis();
        String resultToken = "";
        for (String s : Strings) {
            resultToken += s;
        }
        /* 加上时间戳 */
        resultToken = addTimestamp ? resultToken += timestamp : resultToken;

        /*采用MD5散列算法加密*/
        return DigestUtils.md5DigestAsHex(resultToken.getBytes());
    }

    /**
     * 生成16位加密字符串
     * @param s
     * @return
     */
    public static String tokenGenerator16(boolean addTimestamp, String... s) {
        return tokenGenerator32(addTimestamp, s).substring(8, 24);
    }

    /**
     * 用户名+密码+slot（采用注册时间作为盐）
     * @param Strings
     * @return
     */
    public static String passwordGenerator(String... Strings) {
        String password = "";
        for (String s : Strings) {
            password += s;
        }

        return DigestUtils.md5DigestAsHex(password.getBytes());
    }

}
