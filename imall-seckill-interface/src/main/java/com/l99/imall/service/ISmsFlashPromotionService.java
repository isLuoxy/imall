package com.l99.imall.service;


import com.l99.imall.pojo.CommonResult;
import com.l99.imall.pojo.SmsFlashPromotion;

/**
 * 秒杀商品服务层
 * @author L99
 * @createDate 2019/5/25
 *
 */
public interface ISmsFlashPromotionService {


    /**
     *
     * @param smsFlashPromotion
     * @return
     */
    CommonResult addFlashPromotion(SmsFlashPromotion smsFlashPromotion);
}
