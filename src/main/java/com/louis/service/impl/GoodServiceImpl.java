package com.louis.service.impl;

import com.louis.bean.Cart;
import com.louis.bean.Good;
import com.louis.dao.impl.GoodDaoImp;

import java.util.List;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class GoodServiceImpl {

    private GoodDaoImp goodDaoImp = new GoodDaoImp();

    /**
     * 添加商品
     * @param good
     */
    public int addGood(Good good) {
        return goodDaoImp.addGood(good);
    }

    /**
     * 删除商品
     * @param cartId
     * @param goodId
     * @return
     */
    public int deleteGood(String cartId,Integer goodId) {
        return goodDaoImp.deleteGood(cartId, goodId);
    }

    /**
     * 清空购物车
     * @param cartId
     * @return
     */
    public int clear(String cartId) {
        return goodDaoImp.clearCart(cartId);
    }

    /**
     * 更新商品数量
     * @param cartId
     * @param good
     * @param count
     * @return
     */
    public int update(String cartId,Good good,Integer count) {
        return goodDaoImp.updateGood(cartId,good.getGoodId(),count);
    }

    public List<Good> getAllGoodsByCartId(String cartId) {
        return goodDaoImp.queryGoodsByCartId(cartId);
    }

    public Good getGood(String cartId, Integer goodId) {
        return goodDaoImp.queryGoodByCartIdAndGoodId(cartId,goodId);
    }
}
