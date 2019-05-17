package com.luo.imall.web.service.impl;

import com.luo.imall.web.constant.ErrorCode;
import com.luo.imall.web.dao.OmsCartItemDao;
import com.luo.imall.web.entity.OmsCartItem;
import com.luo.imall.web.service.IOmsCartItemService;
import com.luo.imall.web.vo.CommonResult;
import com.luo.imall.web.vo.CreateOmsCartItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author L99
 * @createDate 2019/5/14
 *
 */
@Service
public class OmsCartItemServiceImpl implements IOmsCartItemService {

    @Autowired
    OmsCartItemDao cartItemDao;

    @Override
    public CommonResult getCart(CreateOmsCartItemRequest omsCartItemRequest) {
        List<OmsCartItem> omsCartItems = cartItemDao.getCart(omsCartItemRequest.toCartItem());

        return new CommonResult(omsCartItems);
    }

    @Override
    public CommonResult addCart(CreateOmsCartItemRequest omsCartItemRequest) {
        boolean result = cartItemDao.addCart(omsCartItemRequest.toCartItem());
        if (result) {
            return CommonResult.success();
        }
        return CommonResult.failure(ErrorCode.ADD_CART_FAILED.getCode(), ErrorCode.ADD_CART_FAILED.getDesc());
    }

    @Override
    public CommonResult getCartByName(String name) {
        List<OmsCartItem> cartByName = cartItemDao.getCartByName(name);
        return new CommonResult(cartByName);
    }
}
