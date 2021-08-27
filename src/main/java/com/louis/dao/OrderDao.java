package com.louis.dao;

import com.louis.bean.Order;

import java.util.List;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public interface OrderDao {

    /**
     * 保存订单
     * @param order
     * @return
     */
    int saveOrder(Order order);

    /**
     * 查询所有订单
     * @return
     */
    List<Order> queryOrders();

    /**
     * 查询用户id
     * @return
     */
    List<Order> queryOrdersByUserId(Integer userId);

    /**
     * 更改订单状态
     * @param orderId
     * @param status
     * @return
     */
    int changeOrderStatus(String orderId,Integer status);
}
