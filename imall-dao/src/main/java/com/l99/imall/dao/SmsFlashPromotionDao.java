package com.l99.imall.dao;

import com.l99.imall.pojo.SmsFlashPromotion;
import org.springframework.stereotype.Repository;

/**
 * 秒杀商品
 * @author L99
 * @createDate 2019/5/25
 *
 */
@Repository
public interface SmsFlashPromotionDao {

    /**
     * 添加秒杀商品
     * @return
     */
    boolean addFlashPromotrion(SmsFlashPromotion smsFlashPromotion);
}
