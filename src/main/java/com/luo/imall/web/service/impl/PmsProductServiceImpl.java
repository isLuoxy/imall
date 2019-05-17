package com.luo.imall.web.service.impl;

import com.luo.imall.web.constant.ErrorCode;
import com.luo.imall.web.dao.PmsProductDao;
import com.luo.imall.web.entity.PmsProduct;
import com.luo.imall.web.service.IPmsProductService;
import com.luo.imall.web.vo.CommonResult;
import com.luo.imall.web.vo.CreatePmsProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品服务层
 * @author L99
 * @createDate 2019/5/15
 *
 */
@Service
public class PmsProductServiceImpl implements IPmsProductService {

    @Autowired
    PmsProductDao pmsProductDao;

    @Override
    public CommonResult findProductById(Long id) {
        List<PmsProduct> products = pmsProductDao.findProductById(id);
        if (products.size() == 0) {
            return CommonResult.failure(ErrorCode.PRODUCT_DOES_NOT_EXIST.getCode(), ErrorCode.PRODUCT_DOES_NOT_EXIST.getDesc());
        }
        return new CommonResult(products);
    }


    @Override
    public CommonResult keywordsFuzzyQuery(CreatePmsProductRequest pmsProductRequest) {
        List<PmsProduct> products = pmsProductDao.keywordsFuzzyQuery(pmsProductRequest.getProductName());

        return new CommonResult(products);
    }

    @Override
    public CommonResult keywordsAccurateQuery(CreatePmsProductRequest pmsProductRequest) {
        List<PmsProduct> products = pmsProductDao.keywordsAccurateQuery(pmsProductRequest.getProductName());
        return new CommonResult(products);
    }

    @Override
    public CommonResult queryProductByInterval(CreatePmsProductRequest pmsProductRequest) {
        List<PmsProduct> products = pmsProductDao.queryProductByInterval(pmsProductRequest.getProductName(), Integer.valueOf(pmsProductRequest.getLowerBoundary()), Integer.valueOf(pmsProductRequest.getUpperBoundary()));
        return new CommonResult(products);
    }
}
