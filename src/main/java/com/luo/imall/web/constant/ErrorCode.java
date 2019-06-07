package com.luo.imall.web.constant;

import org.apache.ibatis.annotations.Update;

/**
 * 错误码枚举定义
 * @author L99
 * @createDate 2019/5/12
 *
 */
public enum ErrorCode {
    /**
     * 注册成功
     */
    SUCCESS(0, ""),

    /**
     * 用户名已存在
     */
    DUPLICATE_NAME(1, "用户名已存在"),

    /**
     *  注册失败，请重新注册
     */
    REGISTER_FAIL(2, "注册失败"),

    /**
     * 账户名与密码不匹配
     */
    NOT_MATCH(3, "账户名与密码不匹配，请重新输入"),

    ADD_CART_FAILED(4, "添加购物车失败"),

    PRODUCT_DOES_NOT_EXIST(5, "该商品不存在"),

    ABNORMAL_STATUE(6, "暂未登陆，请登陆；如已登陆，则可能存在风险问题"),


    INVENTORY_NOT_ENOUGH(7, "商品加购件数（含已加购件数）已超过库存"),

    UPDATE_CART_FAILED(8, "更新购物车失败");


    /** 错误码 */
    private Integer code;

    /** 错误描述 */
    private String desc;

    ErrorCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
