package com.l99.imall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author L99
 * @createDate 2019/5/27
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsFlashPromotionOrderItem implements Serializable {

    private Long id;

    /** 订单 id */
    private Long orderId;

    /** 秒杀商品 id */
    private Long flashPromotionProductId;

    /** 商品名称 */
    private String productName;

    /** 商品价格 */
    private BigDecimal productPrice;

    /** 商品数量 */
    private Integer productQuantity;
}
