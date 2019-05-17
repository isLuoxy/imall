package com.luo.imall.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建商品请求对象
 * @author L99
 * @createDate 2019/5/15
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePmsProductRequest {

    /** 商品名称 */
    private String productName;

    /** 区间上边界 */
    private String upperBoundary;

    /** 区间下边界 */
    private String lowerBoundary;
}
