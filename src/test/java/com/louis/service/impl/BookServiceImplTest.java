package com.louis.service.impl;

import com.louis.bean.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceImplTest {

    private BookServiceImpl bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        Book book = new Book(22,"唐代诗人",new BigDecimal(100),"李太白",67,10,"1022.jpg");
        bookService.addBook(book);
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(23);
    }

    @Test
    public void updateBook() {
        Book book = new Book(1,"诸葛亮",new BigDecimal(100),"若虚",66,14,"1001.jpg");
        bookService.updateBook(book);
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(1);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> bookList = bookService.queryBooks();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}