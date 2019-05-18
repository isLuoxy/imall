package com.luo.imall.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品基础类
 * @author L99
 * @createDate 2019/5/11
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PmsProduct {

    private Long id;

    /**
     *  商品品牌 id
     */
    private Long brandId;

    /**
     * 商品名称
     */
    private String name;


    /**
     * 新品状态:0->不是新品；1->新品
     *
     */
    private Integer newStatus;

    /**
     * 推荐状态；0->不推荐；1->推荐
     *
     */
    private Integer recommandStatus;


    /**
     * 销量
     *
     */
    private Integer sale;


    /**
     * 副标题
     */
    private String subTitle;



    /**
     * 单位
     *
     */
    private String unit;

    /**
     * 商品重量，默认为克
     *
     */
    private BigDecimal weight;


    /**
     * 以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮
     *
     */
    private String serviceIds;

    /**
     * 商品详情标题
     */
    private String detailTitle;

    /**
     * 品牌名称
     */
    private String brandName;


    /**
     * 商品描述
     *
     */
    private String description;


    /**
     * 具体商品规格
     */
    private List<PmsProductAttibuteValue> pmsProductAttibuteValue;

}
