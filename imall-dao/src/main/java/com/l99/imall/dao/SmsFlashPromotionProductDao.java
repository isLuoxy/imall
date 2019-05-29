package com.l99.imall.dao;

import com.l99.imall.pojo.SmsFlashPromotionProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author L99
 * @createDate 2019/5/27
 *
 */
@Repository
public interface SmsFlashPromotionProductDao {


    /**
     * 新增秒杀商品
     * @param flashPromotionProduct {@link SmsFlashPromotionProduct}
     * @return
     */
    boolean addSmsFlashPromotionProduct(SmsFlashPromotionProduct flashPromotionProduct);


    /**
     * 修改秒杀商品库存
     * @param id 秒杀商品的 id
     * @param difference 秒杀商品需要减少的数量
     * @return
     */
    boolean updateSmsFlashPromotionProductInventory(@Param("id") Long id, @Param("difference") Integer difference);
}
