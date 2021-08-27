package com.louis.dao.impl;

import com.louis.bean.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OrderDaoImplTest {

    private OrderDaoImpl orderDao = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        Order order = new Order();
        order.setOrderId("6088586e-5f61-45eb-bc6a-c8b39366a276");
        order.setCreateTime(new Date());
        order.setPrice(new BigDecimal(120));
        order.setStatus(0);
        order.setUserId(1);
        orderDao.saveOrder(order);
    }

    @Test
    public void queryOrders() {
        List<Order> orderList = orderDao.queryOrders();
        System.out.println(orderList);
    }

    @Test
    public void changeOrderStatus() {
        orderDao.changeOrderStatus("6088586e-5f61-45eb-bc6a-c8b39366a276",1);
    }
}