package com.luo.imall.web.controller;

import com.luo.imall.web.service.IPmsProductClassificationService;
import com.luo.imall.web.service.IPmsProductService;
import com.luo.imall.web.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author L99
 * @createDate 2019/5/17
 *
 */
@RestController
@Slf4j
public class PmsproductClassificationController {

    @Autowired
    IPmsProductClassificationService pmsProductClassificationService;


    @Autowired
    IPmsProductService pmsProductService;

    /**
     * 查看所有分类类别
     * @return
     */
    @GetMapping("/classification")
    public Object selectPrimaryClassification() {
        CommonResult result = pmsProductClassificationService.selectAllClassification();
        log.info("{}",result);
        return result;
    }

    /**
     * 根据分类id查看具体的商品
     * @param id 分类id
     * @return
     */
    @GetMapping("/classification/{id}")
    public Object getProductByClassificationId(@PathVariable("id") Long id){
        CommonResult result = pmsProductService.findProductByClassificationId(id);
        log.info("{}",result);
        return result;
    }
}
