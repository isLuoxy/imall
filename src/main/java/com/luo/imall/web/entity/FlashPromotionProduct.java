package com.luo.imall.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 秒杀商品和商品对象封装
 * @author L99
 * @createDate 2019/5/11
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlashPromotionProduct {

    /**
     * 秒杀商品价格
     */
    private BigDecimal flashPromotionPrice;

    /**
     * 秒杀商品数量
     */
    private Integer flashPromotionCount;

    /**
     * 秒杀商品限额
     */
    private Integer flashPromotionLimit;
}
