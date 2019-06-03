package com.luo.imall.web;

import com.luo.imall.web.dao.PmsProductDao;
import com.luo.imall.web.util.OutputUtil;
import net.sf.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author L99
 * @createDate 2019/6/3
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductAttributeValueTest {

    @Autowired
    PmsProductDao pmsProductDao;

    /**
     * @see PmsProductDao#findProductByAttributeValue(Long, String)
     */
    @Test
    public void findProductByAttributeValue() {
        System.out.println(OutputUtil.JSONArray2String(pmsProductDao.findProductByAttributeValue(2l, "{\"颜色\":\"丝绒系列 43#珊瑚红_亲爱\"}")));
    }
}
