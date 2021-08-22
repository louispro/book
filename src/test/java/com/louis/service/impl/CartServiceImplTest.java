package com.louis.service.impl;

import com.louis.bean.Cart;
import com.louis.bean.Good;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartServiceImplTest {

    private CartServiceImpl cartService = new CartServiceImpl();
    @Test
    public void initCart() {
        Cart cart = cartService.initCart("c601e4d2-4311-4459-96f3-310073ca8778");
        System.out.println(cart);
    }

    @Test
    public void addItems() {
        Cart cart = cartService.initCart("c601e4d2-4311-4459-96f3-310073ca8778");
        Good good = new Good();
        good.setCartId("c601e4d2-4311-4459-96f3-310073ca8778");
        good.setGoodId(4);
        good.setGoodName("武则天");
        good.setGoodCount(1);
        good.setGoodPrice(new BigDecimal(33));
        good.setTotalPrice(good.getGoodPrice().multiply(new BigDecimal(good.getGoodCount())));
        cartService.addItems(cart,good);
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = cartService.initCart("c601e4d2-4311-4459-96f3-310073ca8778");
        Good good = new Good();
        good.setCartId("c601e4d2-4311-4459-96f3-310073ca8778");
        good.setGoodId(4);
        good.setGoodName("武则天");
        good.setGoodCount(1);
        good.setGoodPrice(new BigDecimal(33));
        good.setTotalPrice(good.getGoodPrice().multiply(new BigDecimal(good.getGoodCount())));
        cartService.deleteItem(cart,good);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = cartService.initCart("c601e4d2-4311-4459-96f3-310073ca8778");
        cartService.clear(cart);
    }

    @Test
    public void update() {
        Cart cart = cartService.initCart("c601e4d2-4311-4459-96f3-310073ca8778");
        Good good = new Good();
        good.setCartId("c601e4d2-4311-4459-96f3-310073ca8778");
        good.setGoodId(1);
        good.setGoodCount(3);
        good.setGoodName("诸葛亮");
        good.setGoodPrice(new BigDecimal(120));
        good.setTotalPrice(new BigDecimal(360));
        cartService.update(cart,good,-1);
        System.out.println(cart);
    }

    @Test
    public void testDeleteItem() {
        Cart cart = cartService.initCart("d5d222f3-f0e5-4ab5-964a-a4fffbe26297");
        System.out.println(cart);
        Good good = new Good();
        good.setCartId("d5d222f3-f0e5-4ab5-964a-a4fffbe26297");
        good.setGoodId(1);
        good.setGoodCount(1);
        good.setGoodName("诸葛亮");
        good.setGoodPrice(new BigDecimal(120));
        good.setTotalPrice(new BigDecimal(120));
        cartService.deleteItem(cart,good);
        System.out.println(cart);
    }
}