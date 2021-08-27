package com.louis.utils;

import com.louis.bean.Book;
import com.louis.bean.Good;
import com.louis.bean.OrderItem;
import com.mchange.v2.beans.BeansUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class WebUtils {

    public static <T> T copyParamsToBean(Map map, T bean){
        try {
            BeanUtils.populate(bean,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static Integer parseInt(String param,int defaultValue){
        if(param==null)
            return defaultValue;
        return Integer.parseInt(param);
    }

    public static void getUUID(){
        for(int i = 0; i < 5; i++){
            System.out.println(UUID.randomUUID().toString());
        }
    }

    /**
     * 将图书转换为商品
     * @param cartId
     * @param book
     * @return
     */
    public static Good bookToGood(String cartId, Book book) {
        Good good = new Good();
        good.setCartId(cartId);
        good.setGoodId(book.getId());
        good.setGoodName(book.getName());
        good.setGoodCount(1);
        good.setGoodPrice(book.getPrice());
        good.setTotalPrice(book.getPrice());
        return good;
    }

    /**
     * 将商品对象转换成订单对象
     * @return
     */
    public static OrderItem goodToOrdetItem(Good good,String orderId){
        OrderItem orderItem = new OrderItem();
        orderItem.setGoodId(good.getGoodId());
        orderItem.setGoodName(good.getGoodName());
        orderItem.setCount(good.getGoodCount());
        orderItem.setPrice(good.getGoodPrice());
        orderItem.setTotalPrice(good.getTotalPrice());
        orderItem.setOrderId(orderId);
        return orderItem;
    }
}
