package com.luo.imall.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 首页当前秒杀场次信息
 * @author L99
 * @createDate 2019/5/11
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeFlashPromotion {

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 下一次秒杀开始时间
     */
    private Date nextStartTime;

    /**
     * 下一次秒杀结束时间
     */
    private Date nextEndTime;

    /**
     *  属于该秒杀活动的商品
     */
    private List<FlashPromotionProduct> productList;
}
