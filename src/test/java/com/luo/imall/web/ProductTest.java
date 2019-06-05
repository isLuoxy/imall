package com.luo.imall.web;

import com.luo.imall.web.dao.PmsProductDao;
import com.luo.imall.web.entity.PmsProduct;
import net.sf.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 *
 * @author L99
 * @createDate 2019/5/19
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {

    @Autowired
    PmsProductDao pmsProductDao;
    /**
     * {@link PmsProductDao}
     * @see PmsProductDao#findProductBySn(Long)
     */
    @Test
    public void findProductBySn(){
        PmsProduct productBySn = pmsProductDao.findProductBySn(100000177786L);
        System.out.println(JSONArray.fromObject(productBySn).toString());
    }
}
