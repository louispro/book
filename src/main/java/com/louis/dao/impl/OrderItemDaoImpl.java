package com.louis.dao.impl;

import com.louis.bean.OrderItem;
import com.louis.dao.OrderItemDao;

import java.util.List;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    /**
     * 保存订单项
     *
     * @param orderItem
     * @return
     */
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into orderItem values(?,?,?,?,?,?)";
        return update(sql,orderItem.getGoodId(),orderItem.getGoodName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    /**
     * 查询订单
     *
     * @param orderId
     * @return
     */
    @Override
    public List<OrderItem> queryOrdetItemByOrderId(String orderId) {
        String sql = "select * from orderItem where orderId = ?";
        return queryForList(OrderItem.class,sql,orderId);
    }
}
