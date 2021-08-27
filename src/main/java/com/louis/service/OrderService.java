package com.louis.service;

import com.louis.bean.Cart;
import com.louis.bean.Order;
import com.louis.bean.OrderItem;
import com.louis.dao.OrderItemDao;
import com.louis.dao.impl.OrderDaoImpl;
import com.louis.dao.impl.OrderItemDaoImpl;

import java.util.List;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public interface OrderService {


    /**
     * 生成订单
     * @param cart
     * @param userId
     * @return
     */
    int createOrder(Cart cart, Integer userId,String orderId);

    /**
     * 查询所有订单
     * @return
     */
    List<Order> showAllOrders();

    /**
     * 查询用户id
     * @param userId
     * @return
     */
    List<Order> showOrdersByUserId(Integer userId);

    /**
     * 发货
     */
    int sendOrder(String orderId);

    /**
     * 查看订单详情
     * @param orderId
     * @return
     */
    List<OrderItem> showOrdetDetail(String orderId);

    /**
     * 签收
     * @return
     */
    int receiveOrder(String orderId);
}
