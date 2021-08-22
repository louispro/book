package com.louis.bean;

import java.math.BigDecimal;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class Good {
    //商品所在购物车Id
    private String cartId;
    //商品id
    private Integer goodId;
    //商品名称
    private String goodName;
    //商品数量
    private Integer goodCount;
    //商品单价
    private BigDecimal goodPrice;
    //商品总价
    private BigDecimal totalPrice;

    public Good() {
    }

    public Good(String cartId, Integer goodId, String goodName, Integer goodCount, BigDecimal goodPrice, BigDecimal totalPrice) {
        this.cartId = cartId;
        this.goodId = goodId;
        this.goodName = goodName;
        this.goodCount = goodCount;
        this.goodPrice = goodPrice;
        this.totalPrice = totalPrice;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
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

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public BigDecimal getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(BigDecimal goodPrice) {
        this.goodPrice = goodPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Good{" +
                "cartId=" + cartId +
                ", goodId='" + goodId + '\'' +
                ", goodName='" + goodName + '\'' +
                ", goodCount=" + goodCount +
                ", goodPrice=" + goodPrice +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
