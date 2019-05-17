package com.luo.imall.web.dao;

import com.luo.imall.web.entity.PmsProductAttibuteValue;
import org.springframework.stereotype.Repository;

/**
 * 商品sku 自定义Dao
 * @author L99
 * @createDate 2019/5/15
 *
 */
@Repository
public interface PmsProductAttibuteValueDao {

    /**
     * 更新商品 sku 的属性
     * @param pmsProductAttibuteValue {@link PmsProductAttibuteValue}
     * @return
     */
    boolean UpdatePmsPgetPmsProductAttributeValue(PmsProductAttibuteValue pmsProductAttibuteValue);


    /**
     * 减少库存
     * @param pmsProductAttibuteValue {@link PmsProductAttibuteValue}
     * @return
     */
    boolean inventoryReduction(PmsProductAttibuteValue pmsProductAttibuteValue);
}
