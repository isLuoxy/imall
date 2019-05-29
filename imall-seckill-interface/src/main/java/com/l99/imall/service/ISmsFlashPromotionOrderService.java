package com.l99.imall.service;

import com.l99.imall.pojo.CommonResult;
import com.l99.imall.pojo.CreateSmsFlashPromotionOrderRequest;

/**
 * 秒杀商品订单服务层
 * @author L99
 * @createDate 2019/5/27
 *
 */
public interface ISmsFlashPromotionOrderService {


    /**
     * 结算秒杀商品 生成秒杀商品订单
     * @param createSmsFlashPromotionOrderRequest {@link CreateSmsFlashPromotionOrderRequest}
     * @return
     */
    CommonResult addFlashPromotionOrder(CreateSmsFlashPromotionOrderRequest createSmsFlashPromotionOrderRequest);
}
