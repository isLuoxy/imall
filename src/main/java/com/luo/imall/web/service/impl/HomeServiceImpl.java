package com.luo.imall.web.service.impl;

import com.luo.imall.web.constant.HomeConstant;
import com.luo.imall.web.dao.HomeDao;
import com.luo.imall.web.service.IHomeService;
import com.luo.imall.web.vo.HomeContentResult;
import com.luo.imall.web.entity.HomeFlashPromotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 首页内容管理自定义Service
 * @author L99
 * @createDate 2019/5/11
 *
 */
@Service
public class HomeServiceImpl implements IHomeService {


    @Autowired
    HomeDao homeDao;

    @Override
    public HomeContentResult getContent() {
        HomeContentResult result = new HomeContentResult();

        // 获取推荐商品
        result.setRecommendProductList(homeDao.getRecommendProductList(HomeConstant.DEFAULTPAGE));

        // 获取新品推荐
        result.setNewProductList(homeDao.getNewProductList(HomeConstant.DEFAULTPAGE));

        // 获取秒杀商品
        result.setHomeFlashPromotion(getHomeFlashPromotion());

        return result;
    }


    /**
     * 获取当前秒杀活动
     * @return
     */
    private HomeFlashPromotion getHomeFlashPromotion() {
        return null;
    }
}
