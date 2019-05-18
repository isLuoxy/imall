package com.luo.imall.web.service.impl;

import com.luo.imall.web.dao.PmsProductClassificationDao;
import com.luo.imall.web.entity.BriefClassification;
import com.luo.imall.web.service.IPmsProductClassificationService;
import com.luo.imall.web.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author L99
 * @createDate 2019/5/17
 *
 */
@Service
public class PmsProductClassificationServiceImpl implements IPmsProductClassificationService {

    @Autowired
    PmsProductClassificationDao pmsProductClassificationDao;

    @Override
    public CommonResult selectPrimaryClassification() {
        return null;
    }

    @Override
    public CommonResult selectSecondaryClassification(Long id) {
        return null;
    }

    @Override
    public CommonResult selectAllClassification() {
        List<BriefClassification> briefClassifications = pmsProductClassificationDao.selectAllClassification();
        return new CommonResult(briefClassifications);
    }
}
