package com.l99.imall.pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 秒杀类基本类
 * @author L99
 * @createDate 2019/5/25
 *
 */
@Data
public class SmsFlashPromotion implements Serializable {

    private Long id;


    /** 商品 sku id*/
    private Long productId;

    /** 标题 */
    private String title;

    /** 开始时间 */
    private Date startDate;

    /** 结束时间 */
    private Date endDate;

    /** 状态 */
    private String status;

    /** 创建时间 */
    private Date createTime;

    /** 秒杀商品数*/
    private Integer num;

    /** 剩余库存 */
    private Integer stockCount;

    /** 描述 */
    private String introduction;

}
