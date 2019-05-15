package com.luo.imall.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品规格
 * @author L99
 * @createDate 2019/5/14
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PmsProductSpecifications {

    /**
     * 规格名称
     */
    private String name;

    /**
     * 规格值
     */
    private String value;
}
