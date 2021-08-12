package com.louis.dao;

import com.louis.bean.Book;

import java.util.List;

public interface BookDao {

    /**
     * 增加图书
     * @param book
     * @return 1表示成功，-1表示失败
     */
    int addBook(Book book);

    /**
     * 根据id删除图书
     * @param id
     * @return 1表示成功，-1表示失败
     */
    public int deleteBookById(Integer id);

    /**
     * 更新图书
     * @param book
     * @return 1表示成功，-1表示失败
     */
    int updateBook(Book book);

    /**
     * 根据id查询图书
     * @param id
     * @return 返回一个图书对象
     */
    Book queryBookById(Integer id);

    /**
     * 查询许多图书
     * @return 返回一个图书集合
     */
    List<Book> queryBooks();
}
