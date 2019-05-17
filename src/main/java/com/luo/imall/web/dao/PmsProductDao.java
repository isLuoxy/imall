package com.luo.imall.web.dao;

import com.luo.imall.web.entity.PmsProduct;
import org.apache.ibatis.annotations.Param;
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


    /**
     * 通过关键字模糊查询商品
     * @param keyWord 关键词
     * @return
     */
    List<PmsProduct> keywordsFuzzyQuery(String keyWord);

    /**
     * 通过关键词准确查询商品
     * @param keyWord 关键词
     * @return
     */
    List<PmsProduct> keywordsAccurateQuery(String keyWord);

    /**
     *  查找商品并且价格在范围内
     * @param good 商品关键词
     * @param lowerBoundary 下边界
     * @param upperBoundary 上区间
     * @return
     */
    List<PmsProduct> queryProductByInterval(@Param("good") String good,@Param("lowerBoundary") Integer lowerBoundary, @Param("upperBoundary") Integer upperBoundary);



}
