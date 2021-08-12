package com.louis.dao.impl;

import com.louis.bean.Book;
import com.louis.dao.BookDao;

import java.util.List;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "INSERT INTO books(`name`,price,author,sale,stock,imageUrl) VALUES\n" +
                "(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSale(),book.getStock(),book.getImageUrl());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from books where id = ?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update books set name=?,price=?,author=?,sale=?,stock=?,imageUrl=? where id = ?";
        return update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSale(),book.getStock(),book.getImageUrl(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "SELECT `id`,`name`,price,author,sale,stock,imageUrl FROM books WHERE id = ?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select * from books";
        return queryForList(Book.class,sql);
    }
}
