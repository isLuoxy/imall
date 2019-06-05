package com.luo.imall.web;

import com.luo.imall.web.vo.CreateOmsCartItemRequest;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;


/**
 *
 * @author L99
 * @createDate 2019/5/20
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTest {

    @Test
    public void newCartInstance(){
        CreateOmsCartItemRequest request = new CreateOmsCartItemRequest();
        request.setProductId(5l);
        request.setUsername("test");
        request.setQuantity(2);
        request.setProductBrand("香奈儿");
        request.setProductSn(40059751955l);
        request.setProductName("香奈儿（Chanel） 口红 炫亮魅力唇膏 96#橘红色_古灵精怪");
        request.setPrice(new BigDecimal(315));

        System.out.println(JSONObject.fromObject(request).toString());
    }
}
