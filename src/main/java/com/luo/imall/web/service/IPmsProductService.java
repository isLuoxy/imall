package com.luo.imall.web.service;

import com.luo.imall.web.vo.CommonResult;
import com.luo.imall.web.vo.CreatePmsProductRequest;

/**
 * 商品管理自定义Service
 * @author L99
 * @createDate 2019/5/15
 *
 */
public interface IPmsProductService {

    /**
     * 通过 id 查找商品
     * @param id
     * @return  {@link CommonResult}
     */
    CommonResult findProductById(Long id);

    /**
     * 通过关键字模糊查询商品
     * @param pmsProductRequest {@link CreatePmsProductRequest}
     * @return
     */
    CommonResult keywordsFuzzyQuery(CreatePmsProductRequest pmsProductRequest);

    /**
     * 通过关键词准确查询商品
     * @param pmsProductRequest {@link CreatePmsProductRequest}
     * @return
     */
    CommonResult keywordsAccurateQuery(CreatePmsProductRequest pmsProductRequest);


    /**
     * 查找商品并且价格在范围内
     * @param pmsProductRequest {@link CreatePmsProductRequest}
     * @return
     */
    CommonResult queryProductByInterval(CreatePmsProductRequest pmsProductRequest);
}