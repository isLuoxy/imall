package com.luo.imall.web;

import com.luo.imall.web.dao.HomeDao;
import com.luo.imall.web.dao.PmsProductClassificationDao;
import com.luo.imall.web.dao.PmsProductDao;
import com.luo.imall.web.entity.BriefClassification;
import com.luo.imall.web.entity.PmsProduct;
import com.luo.imall.web.service.IHomeService;
import com.luo.imall.web.util.TokenGenerator;
import com.luo.imall.web.vo.CreateOmsOrderItemRequest;
import com.luo.imall.web.vo.CreateOmsOrderRequest;
import com.luo.imall.web.vo.HomeContentResult;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
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

//        for (PmsProduct p : product) {
//            String productAttributeName = p.getPmsProductAttibuteValue();
//            String productAttributeValue = p.getPmsProductAttibuteValue().getProductAttributeValue();
//
//            String[] names = productAttributeName.split(",");
//            String[] values = productAttributeValue.split(",");
//        }
        System.out.println(JSONArray.fromObject(product).toString());
    }

    @Test
    public void getJson() {
        List<CreateOmsOrderRequest> list = new ArrayList<>();
        CreateOmsOrderRequest createOmsOrderRequest = new CreateOmsOrderRequest();
        CreateOmsOrderItemRequest itemRequest = new CreateOmsOrderItemRequest();

        itemRequest.setProductId(1l);
        itemRequest.setProductName("iphone 7");
        itemRequest.setProductPrice(new BigDecimal(4000));
        itemRequest.setProductQuantity(2);

        CreateOmsOrderItemRequest itemRequest2 = new CreateOmsOrderItemRequest();
        itemRequest2.setProductId(2L);
        itemRequest2.setProductName("iphone 7");
        itemRequest2.setProductPrice(new BigDecimal(5000));
        itemRequest2.setProductQuantity(2);

        List<CreateOmsOrderItemRequest> list1 = new ArrayList<>();
        list1.add(itemRequest);
        list1.add(itemRequest2);

        createOmsOrderRequest.setCreateOmsOrderItemRequests(list1);
        createOmsOrderRequest.setMemberId(13l);
        createOmsOrderRequest.setMemberUsername("Test");
        createOmsOrderRequest.setOrderType(0);
        createOmsOrderRequest.setPayAmount(new BigDecimal(18000));
        createOmsOrderRequest.setPayType(1);
        createOmsOrderRequest.setReceiverName("罗先生");
        createOmsOrderRequest.setReceiverPhone("13131313131");
        createOmsOrderRequest.setReceiverProvince("广东省");
        createOmsOrderRequest.setReceiverCity("广州市");
        createOmsOrderRequest.setReceiverRegion("天河区");
        createOmsOrderRequest.setReceiverDetailAddress("龙洞街道广东工业大学内区");


        System.out.println(JSONObject.fromObject(createOmsOrderRequest).toString());
    }

    @Test
    public void parse() {
        String json = "{\"createOmsOrderItemRequests\":[{\"productId\":1,\"productName\":\"iphone 7\",\"productPrice\":5000,\"productQuantity\":2,\"promotionAmount\":0,\"promotionName\":\"\",\"realAmount\":0}],\"freightAmount\":0,\"id\":0,\"memberId\":13,\"memberUsername\":\"Test\",\"note\":\"\",\"orderType\":0,\"payAmount\":10000,\"payType\":1,\"promotionAmount\":0,\"receiverCity\":\"广州市\",\"receiverDetailAddress\":\"龙洞街道广东工业大学内区\",\"receiverName\":\"罗先生\",\"receiverPhone\":\"13131313131\",\"receiverProvince\":\"广东省\",\"receiverRegion\":\"天河区\",\"status\":0,\"totalAmount\":0}\n";
        JSONObject jsonObject = JSONObject.fromObject(json);
        CreateOmsOrderRequest o = (CreateOmsOrderRequest) JSONObject.toBean(jsonObject, CreateOmsOrderRequest.class);
        System.out.println(o);
    }

    @Test
    public void token() {
        String token = "cdd33739-aed7-456a-a2d4-4adeb5efeeda";
        String timestamp = String.valueOf(System.currentTimeMillis());
        String sign = TokenGenerator.tokenGenerator32(false, token, timestamp, token);

        System.out.println(token);
        System.out.println(timestamp);
        System.out.println(sign);
    }

    @Test
    public void million() throws Exception{
        long current = System.currentTimeMillis();
        Thread.sleep(3600000);
        long end = System.currentTimeMillis();
        System.out.println(end-current);
    }

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    PmsProductClassificationDao pmsProductClassificationDao;
    @Test
    public void redisTest(){
        List<BriefClassification> briefClassifications = pmsProductClassificationDao.selectAllClassification();
        System.out.println(JSONArray.fromObject(briefClassifications).toString());
    }

    /**
     * {@link PmsProductDao}
     * @see PmsProductDao#findProductByClassificationId(Long)
     */
    @Test
    public void findProductByClassificationIdTest(){
        List<PmsProduct> productByClassificationId = pmsProductDao.findProductByClassificationId(7l);
        System.out.println(JSONArray.fromObject(productByClassificationId).toString());
    }


}
