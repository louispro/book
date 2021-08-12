package com.louis.bean;

import java.math.BigDecimal;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class Book {
    private Integer id;
    private String name;
    private BigDecimal price;
    private String author;
    private Integer sale;
    private Integer stock;
    private String imageUrl;

    public Book() {
    }

    public Book(Integer id, String name, BigDecimal price, String author, Integer sale, Integer stock, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.sale = sale;
        this.stock = stock;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        if(imageUrl == null)
            this.imageUrl = "default.jpg";
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", sale=" + sale +
                ", stock=" + stock +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
