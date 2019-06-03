package com.luo.imall.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建商品规格请求对象
 * @author L99
 * @createDate 2019/6/3
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePmsProductAttributeValueRequest {

    /** 商品 id*/
    private Long productId;

    /** 商品规格 */
    private String productAttributeValue;

}
