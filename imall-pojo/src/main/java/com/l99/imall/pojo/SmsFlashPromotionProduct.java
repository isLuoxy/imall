package com.l99.imall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * @author L99
 * @createDate 2019/5/27
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsFlashPromotionProduct implements Serializable {

    private Long id;

    /** 秒杀商品所属场次id */
    private Long flashPromotionId;

    /** 秒杀商品id */
    private Long productId;

    /** 状态 */
    private Integer status;

    /** 商品库存数 */
    private Integer num;
}
