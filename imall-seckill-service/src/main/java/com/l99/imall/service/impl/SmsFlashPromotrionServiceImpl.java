package com.l99.imall.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.l99.imall.dao.SmsFlashPromotionDao;
import com.l99.imall.pojo.CommonResult;
import com.l99.imall.pojo.CreateSmsFlashPromotionOrderRequest;
import com.l99.imall.pojo.SmsFlashPromotion;
import com.l99.imall.service.ISmsFlashPromotionService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 秒杀商品服务层实现
 * @author L99
 * @createDate 2019/5/25
 *
 */
@Service(version = "1.0")
public class SmsFlashPromotrionServiceImpl implements ISmsFlashPromotionService {


    @Autowired
    SmsFlashPromotionDao flashPromotionDao;

    @Override
    public CommonResult addFlashPromotion(SmsFlashPromotion smsFlashPromotion) {
        boolean result = flashPromotionDao.addFlashPromotion(smsFlashPromotion);
        if (result) {
            return CommonResult.success();
        }

        return CommonResult.failure(-1, "test desc");
    }
}
