package com.luo.imall.web.service;

import com.luo.imall.web.vo.CommonResult;

/**
 *
 * @author L99
 * @createDate 2019/5/17
 *
 */
public interface IPmsProductClassificationService {

    /**
     * 查询一级分类
     * @return {@link CommonResult}
     */
    CommonResult selectPrimaryClassification();

    /**
     * 根据一级 id 查询二级分类
     * @param id 一级分类id
     * @return {@link CommonResult}
     */
    CommonResult selectSecondaryClassification(Long id);

    /**
     * 获取全部分类
     * @return {@link CommonResult}
     */
    CommonResult selectAllClassification();


}
