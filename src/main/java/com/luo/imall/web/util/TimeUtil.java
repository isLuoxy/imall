package com.luo.imall.web.util;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * @author L99
 * @createDate 2019/5/12
 *
 */
public class TimeUtil {

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * 获取特定格式的时间
     * @return
     */
    public static String FORMATTime2String(String format,Date date) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

}
