package com.luo.imall.web.service.impl;

import com.luo.imall.web.annotation.ToReconstruct;
import com.luo.imall.web.constant.ErrorCode;
import com.luo.imall.web.dao.OmsCartItemDao;
import com.luo.imall.web.dao.PmsProductAttributeValueDao;
import com.luo.imall.web.dao.PmsProductDao;
import com.luo.imall.web.entity.OmsCartItem;
import com.luo.imall.web.service.IOmsCartItemService;
import com.luo.imall.web.vo.CommonResult;
import com.luo.imall.web.vo.CreateOmsCartItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author L99
 * @createDate 2019/5/14
 *
 */
@Service
public class OmsCartItemServiceImpl implements IOmsCartItemService {

    @Autowired
    OmsCartItemDao cartItemDao;

    @Autowired
    PmsProductDao pmsProductDao;

    @Autowired
    PmsProductAttributeValueDao pmsProductAttributeValueDao;

    @ToReconstruct
    @Override
    public CommonResult getCart(CreateOmsCartItemRequest omsCartItemRequest) {
        List<OmsCartItem> omsCartItems = cartItemDao.getCart(omsCartItemRequest.toCartItem(pmsProductDao));
        return new CommonResult(omsCartItems);
    }

    @Override
    public CommonResult addCart(CreateOmsCartItemRequest omsCartItemRequest) {
        /** 判断购物车是否存在该商品，如果存在，则直接添加商品数量 */

        // 查看购物车中是否存在该条商品记录(这里的OmsCartItem 只有id和quantity有值，其余都为默认值)
        OmsCartItem omsCartItem = cartItemDao.getCartByUsernameAndProductAttributeValueId(omsCartItemRequest.getUsername(), omsCartItemRequest.getProductAttributeValueId());

        if (omsCartItem != null) {
            /** 说明存在，则判断添加商品数量后是否会超出商品库存。不会的话直接修改商品数量 */

            // 获取商品库存量
            Integer stock = pmsProductAttributeValueDao.getInventoryByProductAttributeValueId(omsCartItemRequest.getProductAttributeValueId());
            // 当前购物车中的商品数量
            Integer currentQuantity = omsCartItem.getQuantity();
            // 即将添加到购物车的商品数量
            Integer addQuantity = omsCartItemRequest.getQuantity();

            omsCartItemRequest.setId(omsCartItem.getId());

            if (stock < currentQuantity + addQuantity) {
                // 如果库存不足，则返回错误信息，并将商品量设置为库存值
                omsCartItemRequest.setQuantity(stock);
                // 这里将购物车中的商品数量设置为库存量大小，如果更新失败的话，那么就是原商品数量，不抛出错误。而抛出库存不足的错误
                updateCart(omsCartItemRequest);
                return CommonResult.failure(ErrorCode.INVENTORY_NOT_ENOUGH.getCode(), ErrorCode.INVENTORY_NOT_ENOUGH.getDesc(),stock);
            }

            return updateCartByNum(omsCartItemRequest);
        }

        OmsCartItem omsCartItem1 = omsCartItemRequest.toCartItem(pmsProductDao);
        boolean result = cartItemDao.addCart(omsCartItem1);
        if (result) {
            return CommonResult.success();
        }
        return CommonResult.failure(ErrorCode.ADD_CART_FAILED.getCode(), ErrorCode.ADD_CART_FAILED.getDesc());
    }

    @Override
    public CommonResult getCartByName(String name) {
        List<OmsCartItem> cartByName = cartItemDao.getCartByName(name);
        return new CommonResult(cartByName);
    }

    @Override
    public CommonResult updateCart(CreateOmsCartItemRequest omsCartItemRequest) {

        /** 获取商品库存量 */
        // 先获取商品规格id
        Long productAttributeValueId = cartItemDao.getProductAttributeValueIdById(omsCartItemRequest.getId());
        // 通过商品规格id 获取商品库存
        Integer stock = pmsProductAttributeValueDao.getInventoryByProductAttributeValueId(productAttributeValueId);
        if (stock < omsCartItemRequest.getQuantity()) {
            // 库存不足时，设置数量为当前库存，并且返回最大库存
            omsCartItemRequest.setQuantity(stock);
            cartItemDao.updateCart(omsCartItemRequest.update2CartItem());

            return CommonResult.failure(ErrorCode.INVENTORY_NOT_ENOUGH.getCode(), ErrorCode.INVENTORY_NOT_ENOUGH.getDesc(),stock);
        }

        boolean result = cartItemDao.updateCart(omsCartItemRequest.update2CartItem());

        if (result) {
            return CommonResult.success();
        }
        return CommonResult.failure(ErrorCode.UPDATE_CART_FAILED.getCode(), ErrorCode.UPDATE_CART_FAILED.getDesc());
    }

    @Override
    public CommonResult updateCartByNum(CreateOmsCartItemRequest omsCartItemRequest) {

        boolean result = cartItemDao.updateCartByNum(omsCartItemRequest.update2CartItem());
        if (result) {
            return CommonResult.success();
        }
        return CommonResult.failure(ErrorCode.UPDATE_CART_FAILED.getCode(), ErrorCode.UPDATE_CART_FAILED.getDesc());
    }
}
