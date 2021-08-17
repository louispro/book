package com.louis.service;

import com.louis.bean.Book;
import com.louis.bean.Page;

import java.util.List;

public interface BookService {
    void addBook(Book book);

    void deleteBookById(Integer id);

    void updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Page page(Integer pageNo,Integer pageSize);
}
