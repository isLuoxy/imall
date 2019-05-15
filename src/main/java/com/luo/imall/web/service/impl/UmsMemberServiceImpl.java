package com.luo.imall.web.service.impl;

import com.luo.imall.web.constant.ErrorCode;
import com.luo.imall.web.dao.UmsMemberDao;
import com.luo.imall.web.service.IUmsMemberService;
import com.luo.imall.web.vo.CommonResult;
import com.luo.imall.web.vo.CreateUmsMemberRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author L99
 * @createDate 2019/5/12
 *
 */
@Service
public class UmsMemberServiceImpl implements IUmsMemberService {

    @Autowired
    UmsMemberDao umsMemberDao;

    @Override
    public CommonResult validateUserName(CreateUmsMemberRequest request) {

        ErrorCode errorCode = request.validateUserName(umsMemberDao);

        if (errorCode != ErrorCode.SUCCESS) {
            return CommonResult.failure(errorCode.getCode(), errorCode.getDesc());
        }
        return CommonResult.success();
    }

    @Override
    public CommonResult validateRegister(CreateUmsMemberRequest request) {

        ErrorCode errorCode = request.validateRegister(umsMemberDao);

        if (errorCode != ErrorCode.SUCCESS) {
            return CommonResult.failure(errorCode.getCode(), errorCode.getDesc());
        }
        return CommonResult.success();
    }

    @Override
    public CommonResult validateLogin(CreateUmsMemberRequest request) {
        ErrorCode errorCode = request.validateLogin(umsMemberDao);


        if (errorCode != ErrorCode.SUCCESS) {
            return CommonResult.failure(errorCode.getCode(), errorCode.getDesc());
        }

        return CommonResult.success();
    }
}
