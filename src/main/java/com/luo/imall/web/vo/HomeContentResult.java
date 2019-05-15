package com.luo.imall.web.vo;

import com.luo.imall.web.entity.BriefProduct;
import com.luo.imall.web.entity.HomeFlashPromotion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 首页内容返回信息封装
 * @author L99
 * @createDate 2019/5/11
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeContentResult {

    /**
     * 推荐商品
     */
    private List<BriefProduct> RecommendProductList;

    /**
     * 当前秒杀场次
     */
    private HomeFlashPromotion homeFlashPromotion;

    /**
     *  新品推荐
     */
    private List<BriefProduct> newProductList;
}
