package com.louis.dao.impl;

import com.louis.bean.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoImplTest {

    private BookDaoImpl bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        Book book = new Book(null,"唐代诗人",new BigDecimal(100),"李太白",67,10,"1022.jpg");
        bookDao.addBook(book);
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        Book book = new Book(5,"中国皇后全传",new BigDecimal(100),"张宏伟",89,10,"1005.jpg");
        bookDao.updateBook(book);
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(21);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> bookList = bookDao.queryBooks();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        System.out.println(pageTotalCount);
    }

    @Test
    public void queryForItems() {
        List<Book> items = bookDao.queryForItems(4,4);
        for (Book book : items) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        Integer count = bookDao.queryForPageTotalCountByPrice(50,100);
        System.out.println(count);
    }

    @Test
    public void queryForItemsByPrice() {
        List<Book> items = bookDao.queryForItemsByPrice(4,4,50,300);
        for (Book book : items) {
            System.out.println(book);
        }
    }
}