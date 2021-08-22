package com.louis.service;

import com.louis.bean.Cart;
import com.louis.bean.Good;

import java.util.List;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public interface GoodService {

    Good getGood(String cartId,Integer goodId);

    List<Good> getAllGoodsByCartId(String cartId);

    int addGood(Good good);

    int deleteGood(String cartId,Integer goodId);

    int clear(String cartId);

    int update(String cartId,Good good,Integer count);

}
