package com.l99.imall.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.l99.imall.pojo.CreateSmsFlashPromotionOrderRequest;
import com.l99.imall.pojo.SmsFlashPromotion;
import com.l99.imall.service.ISmsFlashPromotionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 秒杀商品控制器类
 * @author L99
 * @createDate 2019/5/25
 *
 */
@RestController
public class SmsFlashPromotionController {

    @Reference(version = "1.0")
    ISmsFlashPromotionService smsFlashPromotionService;

    /**
     * 添加秒杀场次
     * @param smsFlashPromotion {@link SmsFlashPromotion}
     * @return
     */
    @PostMapping("/flash")
    public Object addFlashPromotion(@RequestBody SmsFlashPromotion smsFlashPromotion) {
        return smsFlashPromotionService.addFlashPromotion(smsFlashPromotion);
    }
}
