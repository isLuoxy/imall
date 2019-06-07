package com.luo.imall.web.vo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用返回对象
 * @author L99
 * @createDate 2019/5/11
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonResult {

    /** 错误码 正确返回 0*/
    private Integer errorCode = 0;

    /** 错误信息 正确返回空字符串*/
    private String errorMessage = "";

    /** 返回值对象 */
    private Object data;


    /**
     * 正确响应构造函数
     * @param data
     */
    public CommonResult(Object data) {
        this.data = data;
    }

    /**
     * 空响应
     * @return
     */
    public static CommonResult success() {
        return new CommonResult();
    }

    /**
     * 错误响应
     * @param errorMessage
     * @return
     */
    public static CommonResult failure(Integer code, String errorMessage) {

        return new CommonResult(code, errorMessage, null);
    }


    /**
     * 带有数据的错误响应
     * @param code
     * @param errorMessage
     * @param data
     * @return
     */
    public static CommonResult failure(Integer code, String errorMessage, Object data) {
        return new CommonResult(code, errorMessage, data);
    }
}
