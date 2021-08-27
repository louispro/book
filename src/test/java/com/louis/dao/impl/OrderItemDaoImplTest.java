package com.louis.dao.impl;

import com.louis.bean.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

public class OrderItemDaoImplTest {

    private OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() {
        OrderItem orderItem = new OrderItem();
        orderItem.setGoodId(1);
        orderItem.setGoodName("诸葛亮");
        orderItem.setCount(1);
        orderItem.setPrice(new BigDecimal(120));
        orderItem.setTotalPrice(new BigDecimal(120));
        orderItem.setOrderId(UUID.randomUUID().toString());
        orderItemDao.saveOrderItem(orderItem);
    }

    @Test
    public void queryOrdetItemByOrderId() {
        List<OrderItem> orderItemList = orderItemDao.queryOrdetItemByOrderId("0242a68e-0543-4a19-b987-ef47b9bc2e1d");
        System.out.println(orderItemList);
    }
}