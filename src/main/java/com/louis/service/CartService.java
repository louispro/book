package com.louis.service;

import com.louis.bean.Cart;
import com.louis.bean.Good;

public interface CartService {

    Cart initCart(String cartId);
    /**
     * 添加商品
     * @param good
     * @return
     */
    int addItems(Cart cart, Good good);

    /**
     * 删除商品
     * @param cart
     * @param good
     * @return
     */
    int deleteItem(Cart cart,Good good);

    /**
     * 清空购物车
     * @param cart
     * @return
     */
    int clear(Cart cart);

    /**
     * 更新商品数量
     * @param cart
     * @param good
     * @param count 修改的数量
     * @return
     */
    int update(Cart cart,Good good,Integer count);

    /**
     * 商品是否在购物车中
     * @param cart
     * @param good
     * @return
     */
    boolean goodExists(Cart cart,Good good);

    /**
     * 根据购物车id和商品id获取商品
     */
    Good getGood(String cartId,Integer goodId);
}
