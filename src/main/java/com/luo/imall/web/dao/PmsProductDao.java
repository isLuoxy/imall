package com.luo.imall.web.dao;

import com.luo.imall.web.entity.PmsProduct;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品管理自定义Dao
 * @author L99
 * @createDate 2019/5/14
 *
 */
@Repository
public interface PmsProductDao {


    /**
     * 通过 id 查找商品详情
     * @param id
     * @return
     */
    List<PmsProduct> findProductById(Long id);
}
