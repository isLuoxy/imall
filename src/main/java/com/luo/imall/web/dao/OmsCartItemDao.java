package com.luo.imall.web.dao;

import com.luo.imall.web.entity.OmsCartItem;
import org.apache.ibatis.annotations.Param;
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


    /**
     * 根据用户名和商品规格id查看购物车中是否存在
     * @param username 用户名
     * @param productAttributeValueId 商品规格id
     * @return 返回所在购物车对象，如果为空，说明不存在；存在则返回该对象
     */
    OmsCartItem getCartByUsernameAndProductAttributeValueId(@Param("username") String username, @Param("productAttributeValueId") Long productAttributeValueId);

    /**
     * 根据用户名称获取购物车
     * @param name
     * @return
     */
    List<OmsCartItem> getCartByName(String name);

    /**
     * 更新购物车信息（直接更新库存）
     * @param omsCartItem {@link OmsCartItem}
     * @return
     */
    boolean updateCart(OmsCartItem omsCartItem);

    /**
     * 更新购物车信息（加上特定的数目）
     * @param omsCartItem {@link OmsCartItem}
     * @return
     */
    boolean updateCartByNum(OmsCartItem omsCartItem);

    /**
     * 通过购物车id 获取对应的商品规格id，
     * @return 库存数量
     */
    Long getProductAttributeValueIdById(Long id);
}
