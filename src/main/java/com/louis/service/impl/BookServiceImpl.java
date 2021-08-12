package com.louis.service.impl;

import com.louis.bean.Book;
import com.louis.dao.impl.BookDaoImpl;
import com.louis.service.BookService;

import java.util.List;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class BookServiceImpl implements BookService {

    private BookDaoImpl bookDao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }
}
