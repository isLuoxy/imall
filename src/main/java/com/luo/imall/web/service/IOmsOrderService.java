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

    /**
     * 返回某个用户的全部订单
     * @param createOmsOrderRequest {@link CreateOmsOrderRequest}
     * @return
     */
    CommonResult getAllOrder(CreateOmsOrderRequest createOmsOrderRequest);

    /**
     * 根据订单id查看订单详情
     * @param id
     * @return createOmsOrderRequest {@link CreateOmsOrderRequest}
     */
    CommonResult getOrderDetailsById(Long id);
}
