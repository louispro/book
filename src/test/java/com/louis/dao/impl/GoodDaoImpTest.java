package com.louis.dao.impl;

import com.louis.bean.Good;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

public class GoodDaoImpTest {

    private GoodDaoImp goodDaoImp = new GoodDaoImp();

    @Test
    public void queryGoodsByCartId() {
        List<Good> items = goodDaoImp.queryGoodsByCartId("c601e4d2-4311-4459-96f3-310073ca8778");
        for (Good good : items) {
            System.out.println(good);
        }
    }

    @Test
    public void addGood() {
        Good good = new Good();
        good.setCartId("c601e4d2-4311-4459-96f3-310073ca8778");
        good.setGoodId(4);
        good.setGoodName("武则天");
        good.setGoodCount(1);
        good.setGoodPrice(new BigDecimal(33));
        good.setTotalPrice(good.getGoodPrice().multiply(new BigDecimal(good.getGoodCount())));
        goodDaoImp.addGood(good);
    }

    @Test
    public void deleteGood() {
        goodDaoImp.deleteGood("c601e4d2-4311-4459-96f3-310073ca8778",4);
    }

    @Test
    public void clearCart() {
        goodDaoImp.clearCart("9e1ef47e-7356-40fc-a9e5-a6a7f1c49746");
    }

    @Test
    public void updateGood() {
        goodDaoImp.updateGood("c601e4d2-4311-4459-96f3-310073ca8778",1,1);
    }

    @Test
    public void queryGoodByCartIdAndGoodId() {
        Good good = goodDaoImp.queryGoodByCartIdAndGoodId("d5d222f3-f0e5-4ab5-964a-a4fffbe26297",1);
        System.out.println(good);
    }
}