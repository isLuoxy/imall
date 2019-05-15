package com.luo.imall.web.vo;

import com.luo.imall.web.constant.ErrorCode;
import com.luo.imall.web.dao.UmsMemberDao;
import com.luo.imall.web.entity.UmsMember;
import com.luo.imall.web.util.TokenGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 创建会员请求对象 用于封装用户对象
 * <h2> 注册、登陆、用户详情 </h2>
 * @author L99
 * @createDate 2019/5/12
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUmsMemberRequest {


    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
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
     * 会员等级名称
     */
    private String memberLevelName;

    /**
     * 验证注册时用户名的有效性
     * @param umsMemberDao {@link UmsMemberDao}
     * @return {@link ErrorCode}
     */
    public ErrorCode validateUserName(UmsMemberDao umsMemberDao) {

        if (umsMemberDao.findByName(this.username) != null) {
            return ErrorCode.DUPLICATE_NAME;
        }

        return ErrorCode.SUCCESS;
    }

    public ErrorCode validateRegister(UmsMemberDao umsMemberDao) {
        ErrorCode errorCode = validateUserName(umsMemberDao);
        if (errorCode == ErrorCode.SUCCESS) {
            // 将请求对象转换成用户对象
            UmsMember newMember = toMember();
            // 密码进行加密
            passwordEncrypt(newMember);

            return umsMemberDao.addMember(newMember) ? ErrorCode.SUCCESS : ErrorCode.REGISTER_FAIL;
        }
        return errorCode;
    }

    /**
     * 验证登陆的有效性
     * @param umsMemberDao {@link UmsMemberDao}
     * @return {@link ErrorCode}
     */
    public ErrorCode validateLogin(UmsMemberDao umsMemberDao) {

        String newPassword = encryptedPassword(this.username, this.password);

        if (umsMemberDao.findByNameAndPassword(this.username, newPassword) != null) {
            return ErrorCode.SUCCESS;
        }
        return ErrorCode.NOT_MATCH;
    }

    /**
     * 将请求对象转换为用户对象</h2>
     * @return {@link UmsMember}
     */
    public UmsMember toMember() {
        UmsMember umsMember = new UmsMember();

        umsMember.setUsername(username);
        umsMember.setPassword(password);
        // 设置 注册时间
        umsMember.setCreateTime(new Date());
        return umsMember;
    }


    /**
     * 密码额外操作，将原密码进行加密
     * @param member
     */
    private void passwordEncrypt(UmsMember member) {
        member.setPassword(encryptedPassword(username, password));
    }


    /**
     * 对密码进行 MD5 加密  salt:MD5(用户名+密码)
     * MD5(用户名+密码+MD5(用户名+密码))
     */
    private String encryptedPassword(String username, String password) {

        String salt = TokenGenerator.passwordGenerator(username, password);

        String newPassword = TokenGenerator.passwordGenerator(username, password, salt);

        return newPassword;
    }

}
