package com.luo.imall.web.dao;

import com.luo.imall.web.entity.OmsCartItem;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 购物车自定义Dao
 * @author L99
 * @createDate 2019/5/14
 *
 */
@Repository
public interface OmsCartItemDao {


    /**
     * 根据用户 id 获取购物车
     * @param omsCartItem {@link OmsCartItem}
     * @return
     */
    List<OmsCartItem> getCart(OmsCartItem omsCartItem);

    /**
     * 添加购物车
     * @param omsCartItem {@link OmsCartItem}
     * @return
     */
    boolean addCart(OmsCartItem omsCartItem);
}
