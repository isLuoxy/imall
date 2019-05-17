package com.luo.imall.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 *
 * @author L99
 * @createDate 2019/5/15
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOmsOrderItemRequest {
    /** 商品id */
    private Long productId;

    /** 商品名称 */
    private String productName;

    /** 商品价格 */
    private BigDecimal productPrice;

    /** 销售数量 */
    private Integer ProductQuantity;

    /** 商品促销名称 */
    private String promotionName;

    /** 商品促销金额 */
    private BigDecimal promotionAmount;

    /** 该商品经过优惠后的分解金额 */
    private BigDecimal realAmount;
}
