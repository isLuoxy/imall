package com.luo.imall.web;

import com.luo.imall.web.dao.HomeDao;
import com.luo.imall.web.dao.PmsProductDao;
import com.luo.imall.web.dao.UmsMemberDao;
import com.luo.imall.web.entity.PmsProduct;
import com.luo.imall.web.entity.PmsProductSpecifications;
import com.luo.imall.web.entity.UmsMember;
import com.luo.imall.web.service.IHomeService;
import com.luo.imall.web.vo.HomeContentResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImallWebApplicationTests {


    @Autowired
    IHomeService homeService;

    @Autowired
    HomeDao homeDao;

    @Test
    public void contextLoads() {
        com.alibaba.fastjson.JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();

        HomeContentResult contentResult = homeService.getContent();
        System.out.println(jsonObject.toJSONString(contentResult));

    }

    @Autowired
    PmsProductDao pmsProductDao;

    @Test
    public void test() {
        List<PmsProduct> product = pmsProductDao.findProductById(27L);

        for (PmsProduct p : product) {
            String productAttributeName = p.getProductAttributeName();
            String productAttributeValue = p.getProductAttributeValue();

            String[] names = productAttributeName.split(",");
            String[] values = productAttributeValue.split(",");
            List<PmsProductSpecifications> list = new ArrayList<>(names.length);
            for (int i = 0; i < names.length; i++) {
                PmsProductSpecifications pmsProductSpecifications = new PmsProductSpecifications();
                pmsProductSpecifications.setName(names[i]);
                pmsProductSpecifications.setValue(values[i]);
                list.add(pmsProductSpecifications);
            }
            p.setAttributes(list);
        }

        product.forEach(System.out::println);
    }

}
