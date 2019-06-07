package com.luo.imall.web.dao;

import com.luo.imall.web.entity.PmsProductAttributeValue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 商品sku 自定义Dao
 * @author L99
 * @createDate 2019/5/15
 *
 */
@Repository
public interface PmsProductAttributeValueDao {

    /**
     * 更新商品 sku 的属性
     * @param pmsProductAttributeValue {@link PmsProductAttributeValue}
     * @return
     */
    boolean UpdatePmsProductAttributeValue(PmsProductAttributeValue pmsProductAttributeValue);


    /**
     * 减少库存
     * @param pmsProductAttributeValue {@link PmsProductAttributeValue}
     * @return
     */
    boolean inventoryReduction(PmsProductAttributeValue pmsProductAttributeValue);

    /**
     * 根据商品规格id获取特定商品库存
     * @param productAttributeValueId 商品规格id
     * @return
     */
    Integer getInventoryByProductAttributeValueId(@Param("productAttributeValueId") Long productAttributeValueId);




}
