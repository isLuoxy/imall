package com.luo.imall.web.service;


import com.luo.imall.web.vo.CommonResult;
import com.luo.imall.web.vo.CreateUmsMemberRequest;

/**
 * 会员管理自定义Service
 * @author L99
 * @createDate 2019/5/12
 *
 */
public interface IUmsMemberService {

    /**
     * 验证注册用户名有效性
     * @param request {@link CreateUmsMemberRequest}
     * @return
     */
    CommonResult validateUserName(CreateUmsMemberRequest request);

    /**
     * 验证注册有效性
     * @param request {@link CreateUmsMemberRequest}
     * @return
     */
    CommonResult validateRegister(CreateUmsMemberRequest request);

    /**
     * 验证登陆有效性
     * @param request {@link CreateUmsMemberRequest}
     * @return
     */
    CommonResult validateLogin(CreateUmsMemberRequest request);
}
