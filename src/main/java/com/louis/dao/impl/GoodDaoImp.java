package com.louis.dao.impl;

import com.louis.bean.Good;
import com.louis.dao.GoodDao;

import java.util.List;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class GoodDaoImp extends BaseDao implements GoodDao {
    @Override
    public Good queryGoodByCartIdAndGoodId(String cartId, Integer goodId) {
        String sql = "select * from good where cartId = ? and goodId = ?";
        return queryForOne(Good.class,sql,cartId,goodId);
    }

    /**
     * 查询购物车中的商品
     *
     * @param cartId
     * @return
     */
    @Override
    public List<Good> queryGoodsByCartId(String cartId) {
        String sql = "select * from good where cartId=?";
        return queryForList(Good.class,sql,cartId);
    }

    /**
     * 添加商品
     * @param good
     * @return 返回1表示添加成功，返回-1表示失败
     */
    @Override
    public int addGood(Good good) {
        String sql= "insert into good values(?,?,?,?,?,?)";
        return update(sql,good.getCartId(),good.getGoodId(),good.getGoodName(),good.getGoodCount(),good.getGoodPrice(),good.getTotalPrice());
    }


    /**
     * 删除商品
     * @param cartId
     * @param goodId
     * @return
     */
    @Override
    public int deleteGood(String cartId,Integer goodId) {
        String sql = "delete from good where cartId = ? and goodId = ?";
        return update(sql,cartId,goodId);
    }

    /**
     * 清空购物车中的商品
     *
     * @param cartId
     * @return
     */
    @Override
    public int clearCart(String cartId) {
        String sql = "delete from good where cartId = ?";
        return update(sql,cartId);
    }

    /**
     * 修改商品数量
     * @param cartId
     * @param goodId
     * @return
     */
    @Override
    public int updateGood(String cartId, Integer goodId,Integer count) {
        String sql = "update good set goodCount=?,totalPrice=goodPrice*? where cartId = ? and goodId = ?";
        return  update(sql,count,count,cartId,goodId);
    }
}
