package com.louis.service.impl;

import com.louis.bean.Cart;
import com.louis.bean.Good;
import com.louis.bean.Order;
import com.louis.bean.OrderItem;
import com.louis.dao.impl.OrderDaoImpl;
import com.louis.dao.impl.OrderItemDaoImpl;
import com.louis.service.OrderService;
import com.louis.utils.WebUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class OrderServiceImpl implements OrderService {

    private OrderDaoImpl orderDao = new OrderDaoImpl();
    private OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();

    /**
     * 生成订单
     *
     * @param cart
     * @param userId
     * @return
     */
    @Override
    public int createOrder(Cart cart, Integer userId,String orderId) {
        //创建订单对象
        Order order = new Order();
        order.setOrderId(orderId);
        order.setCreateTime(new Date());
        order.setPrice(cart.getTotalPrice());
        order.setStatus(0);
        order.setUserId(userId);
        //创建订单项
        for (Good good : cart.getItems()) {
            OrderItem orderItem = WebUtils.goodToOrdetItem(good,orderId);
            orderItemDao.saveOrderItem(orderItem);
        }
        return orderDao.saveOrder(order);
    }

    /**
     * 查询所有订单
     *
     * @return
     */
    @Override
    public List<Order> showAllOrders() {
        return  orderDao.queryOrders();
    }

    /**
     * 查询用户id
     *
     * @param userId
     * @return
     */
    @Override
    public List<Order> showOrdersByUserId(Integer userId) {
        return orderDao.queryOrdersByUserId(userId);
    }

    /**
     * 发货
     *
     * @param orderId
     */
    @Override
    public int sendOrder(String orderId) {
        return orderDao.changeOrderStatus(orderId,1);
    }

    /**
     * 查看订单详情
     *
     * @param orderId
     * @return
     */
    @Override
    public List<OrderItem> showOrdetDetail(String orderId) {
        return orderItemDao.queryOrdetItemByOrderId(orderId);
    }

    /**
     * 签收
     * 签收之后，订单和订单项也随之删除
     * @return
     */
    @Override
    public int receiveOrder(String orderId) {
        return orderDao.changeOrderStatus(orderId,2);
    }
}
