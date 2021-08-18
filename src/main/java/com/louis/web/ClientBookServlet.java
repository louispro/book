package com.louis.web;

import com.louis.bean.Book;
import com.louis.bean.Page;
import com.louis.service.impl.BookServiceImpl;
import com.louis.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class ClientBookServlet extends BaseServlet{

    private BookServiceImpl bookService = new BookServiceImpl();

    /**
     * 分页功能的实现
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"),1);
        Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //获取页面page对象
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("client/bookServlet?action=page");
        //后端校验访问页码的合法性
        if(pageNo < 1)
            page.setPageNo(1);
        if(pageNo > page.getPageTotal())
            page.setPageNo(page.getPageTotal());
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }

    protected void pageByPrice(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"),1);
        Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Integer min = WebUtils.parseInt(request.getParameter("min"),0);
        Integer max = WebUtils.parseInt(request.getParameter("max"),999);
        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        //如果价格区间不为空则加入url中
        if(min != null){
            sb.append("&min=").append(request.getParameter("min"));
        }
        if(max != null){
            sb.append("&max=").append(request.getParameter("max"));
        }
        //获取页面page对象
        Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);
        page.setUrl(sb.toString());
        //后端校验访问页码的合法性
        if(pageNo < 1)
            page.setPageNo(1);
        if(pageNo > page.getPageTotal())
            page.setPageNo(page.getPageTotal());
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }
}
