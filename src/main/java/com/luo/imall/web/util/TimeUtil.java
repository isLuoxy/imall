package com.luo.imall.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * @author L99
 * @createDate 2019/5/12
 *
 */
public class TimeUtil {

    public static final String YMDT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取特定格式的时间
     * @return
     */
    public static String FORMATTime2String(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(YMDT);
        return df.format(date);
    }
}
