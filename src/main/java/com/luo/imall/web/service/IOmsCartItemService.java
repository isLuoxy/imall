package com.luo.imall.web.service;

import com.luo.imall.web.vo.CommonResult;
import com.luo.imall.web.vo.CreateOmsCartItemRequest;

/**
 * 购物车
 * @author L99
 * @createDate 2019/5/14
 *
 */
public interface IOmsCartItemService {

    /**
     * 查看某个用户的购物车
     * @param omsCartItemRequest {@link CreateOmsCartItemRequest}
     * @return {@link CommonResult}
     */
    CommonResult getCart(CreateOmsCartItemRequest omsCartItemRequest);

    /**
     * 添加商品到购物车
     * @param omsCartItemRequest {@link CreateOmsCartItemRequest}
     * @return {@link CommonResult}
     */
    CommonResult addCart(CreateOmsCartItemRequest omsCartItemRequest);
}
