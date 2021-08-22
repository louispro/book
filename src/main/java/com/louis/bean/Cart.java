package com.louis.bean;

import java.math.BigDecimal;
import java.util.List;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class Cart {
    //购物车id
    private String cartId;
    //总商品数量
    private Integer totalCount;
    //总商品金额
    private BigDecimal totalPrice;
    //商品项
    private List<Good> items;

    public Cart() {
    }

    public Cart(String cartId, Integer totalCount, BigDecimal totalPrice, List<Good> items) {
        this.cartId = cartId;
        this.totalCount = totalCount;
        this.totalPrice = totalPrice;
        this.items = items;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Good> getItems() {
        return items;
    }

    public void setItems(List<Good> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", totalCount=" + totalCount +
                ", totalPrice=" + totalPrice +
                ", items=" + items +
                '}';
    }
}
