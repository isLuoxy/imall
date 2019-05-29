package com.l99.imall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.l99.imall.pojo.CreateSmsFlashPromotionOrderRequest;
import com.l99.imall.service.ISmsFlashPromotionOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 秒杀订单控制器
 * @author L99
 * @createDate 2019/5/28
 *
 */
@RestController
public class SmsFlashPromotionOrderController {

    /** 秒杀订单服务层 */
    @Reference(version = "1.0")
    ISmsFlashPromotionOrderService smsFlashPromotionOrderService;

    @PostMapping("/order")
    public Object addFlashPromotionOrder(@RequestBody CreateSmsFlashPromotionOrderRequest smsFlashPromotionOrderRequest) {
        // 添加秒杀订单
        return smsFlashPromotionOrderService.addFlashPromotionOrder(smsFlashPromotionOrderRequest);
    }
}
