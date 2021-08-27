package com.louis.bean;

import java.math.BigDecimal;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class OrderItem {
    //商品id
    private Integer goodId;
    //商品名
    private String goodName;
    //商品数量
    private Integer count;
    //商品单价
    private BigDecimal price;
    //商品总价
    private BigDecimal totalPrice;
    //订单号
    private String orderId;

    public OrderItem() {
    }

    public OrderItem(Integer goodId, String goodName, Integer count, BigDecimal price, BigDecimal totalPrice, String orderId) {
        this.goodId = goodId;
        this.goodName = goodName;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
        this.orderId = orderId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "goodId=" + goodId +
                ", goodName='" + goodName + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
