package com.luo.imall.web.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 输出测试封装工具
 * @author L99
 * @createDate 2019/6/3
 *
 */
public class OutputUtil {


    public static String JSONArray2String(Object o) {
        return JSONArray.fromObject(o).toString();
    }

    public static String JSONObject2String(Object o) {
        return JSONObject.fromObject(o).toString();
    }
}
