package com.l99.imall.service;

import com.l99.imall.pojo.CommonResult;
import com.l99.imall.pojo.SmsFlashPromotionProduct;

/**
 * 秒杀商品服务层
 * @author L99
 * @createDate 2019/5/27
 *
 */
public interface ISmsFlashPromotionProductService {

    /**
     * 添加秒杀商品
     * @param flashPromotionProduct
     * @return
     */
    CommonResult addFlashPromotionProduct(SmsFlashPromotionProduct flashPromotionProduct);

    /**
     * 修改秒杀商品库存
     * @param smsFlashPromotion
     * @return
     */
    CommonResult updateFlashPromotionProduct(SmsFlashPromotionProduct smsFlashPromotion);
}
