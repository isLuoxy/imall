package com.l99.imall.dao;

import com.l99.imall.pojo.SmsFlashPromotionOrderItem;
import org.springframework.stereotype.Repository;

/**
 * 秒杀商品订单详情类
 * @author L99
 * @createDate 2019/5/27
 *
 */
@Repository
public interface SmsFlashPromotionOrderItemDao {

    /**
     * 添加秒杀商品订单详情
     * @param flashPromotionOrderItem {@link SmsFlashPromotionOrderItem}
     * @return
     */
    boolean addFlashPromotionOrderItem(SmsFlashPromotionOrderItem flashPromotionOrderItem);
}
