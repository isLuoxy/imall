package com.luo.imall.web.dao;

import com.luo.imall.web.entity.BriefProduct;
import com.luo.imall.web.entity.FlashPromotionProduct;
import com.luo.imall.web.entity.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 首页内容管理自定义Dao
 * @author L99
 * @createDate 2019/5/11
 *
 */
@Repository
public interface HomeDao {

    /**
     * 获取推荐商品列表
     * @param page {@link Page}
     * @return
     */
    List<BriefProduct> getRecommendProductList(Page page);

    /**
     * 获取秒杀商品列表
     * @param page {@link Page}
     * @return
     */
    List<FlashPromotionProduct> getFlashProductList(Page page);


    /**
     * 获取新品商品列表
     * @param page {@link Page}
     * @return
     */
    List<BriefProduct> getNewProductList(Page page);
}
