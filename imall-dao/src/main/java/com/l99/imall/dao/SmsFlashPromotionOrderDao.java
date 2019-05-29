package com.l99.imall.dao;

import com.l99.imall.pojo.SmsFlashPromotionOrder;
import org.springframework.stereotype.Repository;

/**
 * 秒杀商品订单类
 * @author L99
 * @createDate 2019/5/27
 *
 */
@Repository
public interface SmsFlashPromotionOrderDao {

    /**
     * 添加秒杀订单
     * @param smsFlashPromotionOrder {@link SmsFlashPromotionOrder}
     * @return 返回订单的id，用于记录订单详情信息商品
     */
    Long addFlashPromotionOrder(SmsFlashPromotionOrder smsFlashPromotionOrder);
}
