package com.luo.imall.web.service;

import com.luo.imall.web.vo.CommonResult;
import com.luo.imall.web.vo.CreateOmsOrderRequest;

/**
 * 订单管理自定义Service
 * @author L99
 * @createDate 2019/5/15
 *
 */
public interface IOmsOrderService {

    /**
     * 新增订单
     * @return
     */
    CommonResult addOmsOrder(CreateOmsOrderRequest createOmsOrderRequest) throws Exception;
}
