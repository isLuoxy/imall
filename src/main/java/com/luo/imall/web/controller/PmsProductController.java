package com.luo.imall.web.controller;

import com.luo.imall.web.service.IPmsProductService;
import com.luo.imall.web.vo.CreatePmsProductAttributeValueRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品控制器
 * @author L99
 * @createDate 2019/5/14
 *
 */
@RestController
@Slf4j
public class PmsProductController {


    @Autowired
    IPmsProductService pmsProductService;

    /**
     * 根据商品编号获取商品详情
     * @return
     */
    @GetMapping("/product/{id}")
    public Object productDetail(@PathVariable Long id) {
        return pmsProductService.findProductBySn(id);
    }

    /**
     * 通过商品规格查找商品编号
     * @param pmsProductAttributeValueRequest
     * @return
     */
    @PostMapping("/product")
    public Object product(@RequestBody CreatePmsProductAttributeValueRequest pmsProductAttributeValueRequest) {
        log.info("商品规格: {}", pmsProductAttributeValueRequest);
        return pmsProductService.findProductByAttributeValue(pmsProductAttributeValueRequest);
    }
}
