package com.louis.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class Order {
    //未发货
    public static final Integer UN_DELIVERY = 0;
    //已发货
    public static final Integer DELIVERY = 1;
    //已签收
    public static final Integer RECEIVED = 2;

    //订单号，唯一
    private String orderId;
    //用户编号
    private Integer userId;
    //下单时间
    private Date createTime;
    //订单金额
    private BigDecimal price;
    //订单状态
    private Integer status = UN_DELIVERY;
    public Order() {
    }

    public Order(String orderId, Integer userId, Date createTime, BigDecimal price, Integer status) {
        this.orderId = orderId;
        this.userId = userId;
        this.createTime = createTime;
        this.price = price;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", price='" + price + '\'' +
                ", status=" + status +
                '}';
    }
}
