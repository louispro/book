package com.louis.dao;

import com.louis.bean.Good;

import java.util.List;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public interface GoodDao {

    Good queryGoodByCartIdAndGoodId(String cartId,Integer goodId);
    /**
     * 查询购物车中的商品
     * @param cartId
     * @return
     */
    List<Good> queryGoodsByCartId(String cartId);

    /**
     * 添加商品
     * @param good
     * @return 返回1表示添加成功，返回-1表示失败
     */
    int addGood(Good good);

    /**
     * 删除商品
     * @param cartId
     * @param goodId
     * @return
     */
    int deleteGood(String cartId,Integer goodId);

    /**
     * 清空购物车中的商品
     * @param cartId
     * @return
     */
    int clearCart(String cartId);

    /**
     * 修改商品数量
     * @param cartId
     * @param goodId
     * @return
     */
    int updateGood(String cartId,Integer goodId,Integer count);
}
