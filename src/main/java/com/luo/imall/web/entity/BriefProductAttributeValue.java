package com.luo.imall.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品编号封装 用于返回根据商品规格查找商品
 * @author L99
 * @createDate 2019/6/3
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BriefProductAttributeValue {

    /** 商品编号 */
    private Long productSn;
}
