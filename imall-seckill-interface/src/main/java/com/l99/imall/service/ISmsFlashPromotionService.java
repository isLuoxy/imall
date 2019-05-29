package com.l99.imall.service;


import com.l99.imall.pojo.CommonResult;
import com.l99.imall.pojo.CreateSmsFlashPromotionOrderRequest;
import com.l99.imall.pojo.SmsFlashPromotion;

/**
 * 秒杀商品服务层
 * @author L99
 * @createDate 2019/5/25
 *
 */
public interface ISmsFlashPromotionService {


    /**
     * 添加新的秒杀商品场次
     * @param smsFlashPromotion {@link SmsFlashPromotion}
     * @return
     */
    CommonResult addFlashPromotion(SmsFlashPromotion smsFlashPromotion);

}
