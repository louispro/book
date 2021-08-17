package com.louis.service.impl;

import com.louis.bean.Book;
import com.louis.bean.Page;
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

    @Override
    public Page<Book> page(Integer pageNo,Integer pageSize) {
        Page<Book> page = new Page<>();
        //当前页码
        page.setPageNo(pageNo);
        //每页显示书的数目
        page.setPageSize(pageSize);
        //总的记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        //总的页码数
        if(pageTotalCount%pageSize > 0)
            page.setPageTotal(pageTotalCount/pageSize+1);
        else
            page.setPageTotal(pageTotalCount/pageSize);
        //当前页包含的书的集合
        Integer begin = (pageNo-1)*pageSize;
        List<Book> items = bookDao.queryForItems(begin,pageSize);
        page.setItems(items);
        return page;
    }


}
