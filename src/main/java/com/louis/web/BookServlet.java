package com.louis.web;

import com.louis.bean.Book;
import com.louis.bean.User;
import com.louis.service.impl.BookServiceImpl;
import com.louis.utils.WebUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                        fileItem.write(new File("D:\\Codes\\JavaCode\\Book\\src\\main\\webapp\\static\\img\\book\\"+fileItem.getName()));
                    }
                }
                Book book = WebUtils.copyParamsToBean(map,new Book());
                System.out.println(book);
                bookService.addBook(book);
                response.sendRedirect(request.getContextPath()+"/manager/book?action=list");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        bookService.deleteBookById(id);
        response.sendRedirect(request.getContextPath()+"/manager/book?action=list");
        File image = new File("D:\\Codes\\JavaCode\\Book\\src\\main\\webapp\\static\\img\\book\\"+request.getParameter("imageUrl"));
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
                        //无论如何删除之前的照片
                        File image = new File("D:\\Codes\\JavaCode\\Book\\src\\main\\webapp\\static\\img\\book\\"+fileItem.getName());
                        image.delete();
                        fileItem.write(new File("D:\\Codes\\JavaCode\\Book\\src\\main\\webapp\\static\\img\\book\\"+fileItem.getName()));
                    }
                }
                Book book = WebUtils.copyParamsToBean(map,new Book());
                System.out.println(book);
                bookService.updateBook(book);
                response.sendRedirect(request.getContextPath()+"/manager/book?action=list");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

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
}
