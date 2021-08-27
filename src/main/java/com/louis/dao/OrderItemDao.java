package com.louis.dao;

import com.louis.bean.OrderItem;

import java.util.List;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public interface OrderItemDao {

    /**
     * 保存订单项
     * @return
     */
    int saveOrderItem(OrderItem orderItem);

    /**
     * 查询订单
     * @param orderId
     * @return
     */
    List<OrderItem> queryOrdetItemByOrderId(String orderId);
}
