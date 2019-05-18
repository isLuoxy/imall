package com.luo.imall.web.dao;

import com.luo.imall.web.entity.BriefClassification;
import com.luo.imall.web.entity.PmsProductClassification;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品分类 自定义Dao
 * @author L99
 * @createDate 2019/5/17
 *
 */
@Repository
public interface PmsProductClassificationDao {


    /**
     * 查找所有商品分类
     * @return {@link BriefClassification}
     */
    List<BriefClassification> selectAllClassification();
}
