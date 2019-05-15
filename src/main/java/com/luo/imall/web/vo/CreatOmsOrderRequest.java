package com.luo.imall.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建订单请求对象 用于封装订单对象
 * @author L99
 * @createDate 2019/5/15
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatOmsOrderRequest {

    private Long productId;

    private Long productName;


}
