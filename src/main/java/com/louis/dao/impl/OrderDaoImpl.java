package com.louis.dao.impl;

import com.louis.bean.Order;
import com.louis.dao.OrderDao;

import java.util.List;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    /**
     * 保存订单
     *
     * @param order
     * @return
     */
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into `order` values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    /**
     * 查询用户订单
     * @return
     */
    @Override
    public List<Order> queryOrders() {
        String sql = "select * from `order`";
        return queryForList(Order.class,sql);
    }

    /**
     * 查询用户id
     *
     * @return
     */
    @Override
    public List<Order> queryOrdersByUserId(Integer userId) {
        String sql = "select * from `order` where userId = ?";
        return queryForList(Order.class,sql,userId);
    }

    /**
     * 更改订单状态
     *
     * @param orderId
     * @param status
     * @return
     */
    @Override
    public int changeOrderStatus(String orderId, Integer status) {
        String sql = "update `order` set `status` = ? where orderId = ?";
        return update(sql,status,orderId);
    }
}
