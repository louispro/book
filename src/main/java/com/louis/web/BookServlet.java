package com.louis.web;

import com.louis.bean.Book;
import com.louis.bean.Page;
import com.louis.bean.User;
import com.louis.service.impl.BookServiceImpl;
import com.louis.utils.WebUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileDeleteStrategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class BookServlet extends BaseServlet{

    private BookServiceImpl bookService = new BookServiceImpl();

    protected void add(HttpServletRequest request, HttpServletResponse response){
//        Book book  = WebUtils.copyParamsToBean(request.getParameterMap(),new Book());
//        bookService.addBook(book);
//        request.getRequestDispatcher("/manager/book?action=list");
        if(ServletFileUpload.isMultipartContent(request)){
            //创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                //解析上传的数据
                List<FileItem> list = servletFileUpload.parseRequest(request);
                Map<String,String> map = new HashMap<>();
                //循环判断，每一个表单项是普通类型还是上传的文件
                for(FileItem fileItem:list){
                    if(fileItem.isFormField()){
                        //普通表单项
                        System.out.println("表单项的name属性值："+fileItem.getFieldName());
                        map.put(fileItem.getFieldName(),fileItem.getString("UTF-8"));
                        System.out.println("表单项的value属性值："+fileItem.getString("UTF-8"));
                    }else {
                        System.out.println("表单项的name属性值："+fileItem.getFieldName());
                        System.out.println("上传的文件名："+fileItem.getName());
                        map.put(fileItem.getFieldName(),fileItem.getName());
                        fileItem.write(new File("C:\\Users\\louis_lai\\Desktop\\DeskTemp\\resources\\static\\img\\book\\"+fileItem.getName()));
                    }
                }
                Book book = WebUtils.copyParamsToBean(map,new Book());
                Integer pageNo = WebUtils.parseInt(map.get("pageNo"),1);
                pageNo+=1;
                System.out.println(book);
                bookService.addBook(book);
                response.sendRedirect(request.getContextPath()+"/manager/book?action=page&pageNo="+pageNo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        bookService.deleteBookById(id);
        Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"),1);
        response.sendRedirect(request.getContextPath()+"/manager/book?action=page&pageNo="+pageNo);
        File image = new File("C:\\Users\\louis_lai\\Desktop\\DeskTemp\\resources\\static\\img\\book\\"+request.getParameter("imageUrl"));
        boolean delete = image.delete();
        System.out.println(delete);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(ServletFileUpload.isMultipartContent(request)){
            //创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                //解析上传的数据
                List<FileItem> list = servletFileUpload.parseRequest(request);
                Map<String,String> map = new HashMap<>();
                //循环判断，每一个表单项是普通类型还是上传的文件
                for(FileItem fileItem:list){
                    if(fileItem.isFormField()){
                        //普通表单项
                        System.out.println("表单项的name属性值："+fileItem.getFieldName());
                        map.put(fileItem.getFieldName(),fileItem.getString("UTF-8"));
                        System.out.println("表单项的value属性值："+fileItem.getString("UTF-8"));
                    }else {
                        System.out.println("表单项的name属性值："+fileItem.getFieldName());
                        System.out.println("上传的文件名："+fileItem.getName());
                        map.put(fileItem.getFieldName(),fileItem.getName());
                        File image = new File("C:\\Users\\louis_lai\\Desktop\\DeskTemp\\resources\\static\\img\\book\\"+fileItem.getName());
                        image.delete();
                        fileItem.write(new File("C:\\Users\\louis_lai\\Desktop\\DeskTemp\\resources\\static\\img\\book\\"+fileItem.getName()));
                    }
                }
                Book book = WebUtils.copyParamsToBean(map,new Book());
                System.out.println(book);
                bookService.updateBook(book);
                Integer pageNo = WebUtils.parseInt(map.get("pageNo"),1);
                response.sendRedirect(request.getContextPath()+"/manager/book?action=page&pageNo="+pageNo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Deprecated
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList = bookService.queryBooks();
        request.setAttribute("bookList",bookList);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.queryBookById(id);
        request.setAttribute("book",book);
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);
    }

    /**
     * 分页功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"),1);
        Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"),Page.PAGE_SIZE);
        System.out.println(0);
        //获取页面page对象
        Page<Book> page = bookService.page(pageNo,pageSize);
        //后端校验访问页码的合法性
        if(pageNo < 1)
            page.setPageNo(1);
        if(pageNo > page.getPageTotal())
            page.setPageNo(page.getPageTotal());
        System.out.println(1);
        request.setAttribute("page",page);
        System.out.println(2);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }
}
