package com.l99.imall.dao;

import com.l99.imall.pojo.SmsFlashPromotion;
import org.apache.ibatis.annotations.Param;
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
     * 添加秒杀场次
     * @param smsFlashPromotion {@link SmsFlashPromotion}
     * @return
     */
    boolean addFlashPromotion(SmsFlashPromotion smsFlashPromotion);

    /**
     * 修改秒杀商品库存
     * @param productId 秒杀商品的 id
     * @param different 秒杀商品需要减少的数量
     * @return
     */
    boolean updateFlashInventory(@Param("productId") Long productId,@Param("difference") Integer different);
}
