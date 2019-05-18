package com.luo.imall.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单内容中商品返回信息封装
 * @author L99
 * @createDate 2019/5/18
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BriefOrderItem {

    /**
     * 商品编号
     */
    private Long productSn;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private String price;

    /**
     * 商品购买数量
     */
    private Integer quantity;
}
