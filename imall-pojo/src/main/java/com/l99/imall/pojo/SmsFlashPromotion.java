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


    /** 标题 */
    private String title;

    /** 开始日期 */
    private Date startDate;

    /** 结束日期 */
    private Date endDate;

    /** 开始时间 */
    private Date startTime;

    /** 结束时间 */
    private Date endTime;

    /** 描述 */
    private String introduction;

}
