package com.luo.imall.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * 会员基本信息
 * @author L99
 * @createDate 2019/5/12
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsMember {


    private Long id;

    /**
     * 会员等级 id
     */
    private Long memberLevelId;

    /**
     * 会员等级名称
     */
    private String memberLevelName;

    /**
     * 用户名
     *
     */
    private String username;

    /**
     * 密码
     *
     */
    private String password;

    /**
     * 昵称
     *
     */
    private String nickname;

    /**
     * 手机号码
     *
     */
    private String phone;

    /**
     * 账号启动状态：0 -> 禁用， 1 -> 启用
     *
     */
    private Integer status;

    /**
     * 注册时间
     *
     */
    private Date createTime;

    /**
     * 性别： 0 -> 未知，1 -> 男 ，2 -> 女
     *
     */
    private Integer gender;

    /**
     * 生日
     *
     */
    private Date birthday;

    /**
     * 成长值
     *
     */
    private Integer growth;

}
