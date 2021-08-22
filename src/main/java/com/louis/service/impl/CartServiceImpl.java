package com.louis.service.impl;

import com.louis.bean.Cart;
import com.louis.bean.Good;
import com.louis.service.CartService;

import java.math.BigDecimal;
import java.util.List;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class CartServiceImpl implements CartService {

    private GoodServiceImpl goodService = new GoodServiceImpl();


    @Override
    public Cart initCart(String cartId) {
        Cart cart = new Cart();
        cart.setCartId(cartId);
        List<Good> items = goodService.getAllGoodsByCartId(cartId);
        Integer totalCount = 0;
        BigDecimal totalPrice = new BigDecimal(0);
        for (Good good : items) {
            totalCount += good.getGoodCount();
            totalPrice = totalPrice.add(good.getTotalPrice());
        }
        cart.setTotalCount(totalCount);
        cart.setTotalPrice(totalPrice);
        cart.setItems(items);
        return cart;
    }

    /**
     * 添加商品
     * @param cart
     * @param good
     * @return
     */
    @Override
    public int addItems(Cart cart, Good good) {
        int add = goodService.addGood(good);
        //添加商品之后立马更新购物车
        cart.getItems().add(good);
        cart.setTotalCount(cart.getTotalCount()+good.getGoodCount());
        cart.setTotalPrice(cart.getTotalPrice().add(good.getTotalPrice()));
        return add;
    }



    /**
     * 删除商品
     *
     * @param cart
     * @param good
     * @return
     */
    @Override
    public int deleteItem(Cart cart, Good good) {
        List<Good> items = cart.getItems();
        int i = 0;
        for (Good item : items) {
            if(item.getGoodId().equals(good.getGoodId())){
                break;
            }
            i++;
        }
        items.remove(i);
        cart.setTotalCount(cart.getTotalCount()-good.getGoodCount());
        cart.setTotalPrice(cart.getTotalPrice().subtract(good.getTotalPrice()));
        for (Good item : cart.getItems()) {
            System.out.println(item);
        }
        int delete = goodService.deleteGood(cart.getCartId(),good.getGoodId());
        return delete;
    }

    /**
     * 清空购物车
     *
     * @param cart
     * @param cart
     * @return
     */
    @Override
    public int clear(Cart cart) {
        int clear = goodService.clear(cart.getCartId());
        cart.setTotalCount(0);
        cart.setTotalPrice(new BigDecimal(0));
        cart.getItems().clear();
        return clear;
    }

    /**
     * 更新商品数量
     *
     * @param cart
     * @param good
     * @return
     */
    @Override
    public int update(Cart cart, Good good,Integer count) {
        int update = goodService.update(cart.getCartId(),good,count);
        cart.setTotalCount(cart.getTotalCount()+count);
        cart.setTotalPrice(cart.getTotalPrice().add(good.getGoodPrice().multiply(new BigDecimal(count))));
        List<Good> items = cart.getItems();
        for (Good item : items) {
            if(item.getGoodId().equals(good.getGoodId())){
                item.setGoodCount(item.getGoodCount()+count);
                item.setTotalPrice(item.getTotalPrice().add(item.getGoodPrice().multiply(new BigDecimal(count))));
            }
        }
        return update;
    }

    /**
     * 商品是否在购物车中
     *
     * @param cart
     * @param good
     * @return
     */
    @Override
    public boolean goodExists(Cart cart, Good good) {
        List<Good> items = cart.getItems();
        for (Good item : items) {
            if(item.getGoodId().equals(good.getGoodId()))
                return true;
        }
        return false;
    }

    /**
     * 根据购物车id和商品id获取商品
     *
     * @param cartId
     * @param goodId
     */
    @Override
    public Good getGood(String cartId, Integer goodId) {
        return goodService.getGood(cartId,goodId);
    }


}
