package com.louis.web;

import com.google.gson.Gson;
import com.louis.bean.Book;
import com.louis.bean.Cart;
import com.louis.bean.Good;
import com.louis.bean.User;
import com.louis.service.BookService;
import com.louis.service.CartService;
import com.louis.service.impl.BookServiceImpl;
import com.louis.service.impl.CartServiceImpl;
import com.louis.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet {

    private BookServiceImpl bookService = new BookServiceImpl();
    private CartServiceImpl cartService = new CartServiceImpl();

    protected void addGood(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"),1);
        //获取用户信息和购物车
        User user = (User)session.getAttribute("user");
        Cart cart = (Cart)session.getAttribute("cart");
        Integer bookId = Integer.parseInt(request.getParameter("bookId"));
        Book book = bookService.queryBookById(bookId);
        Good good = WebUtils.bookToGood(user.getCartId(),book);
        boolean goodExists = cartService.goodExists(cart,good);
        //商品不在购物车中，加入购物车
        if(goodExists == false){
            cartService.addItems(cart,good);
        }
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("totalCount",cart.getTotalCount());
        resultMap.put("goodName",good.getGoodName());
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        response.getWriter().write(json);
//        session.setAttribute("lastGood",good.getGoodName());
//        response.sendRedirect(request.getContextPath()+"/client/bookServlet?action=page&pageNo="+pageNo);
    }


    protected void deleteGood(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String cartId = request.getParameter("cartId");
        Integer goodId = Integer.parseInt(request.getParameter("goodId"));
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Good good = cartService.getGood(cartId,goodId);
        cartService.deleteItem(cart,good);
        response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
    }

    protected void clear(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //购物车为空
        if(cart != null){
            cartService.clear(cart);
        }
        response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
    }

    protected void updateCount(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Integer goodId = Integer.parseInt(request.getParameter("goodId"));
        Integer count = WebUtils.parseInt(request.getParameter("count"),1);
        Good good = cartService.getGood(cart.getCartId(),goodId);
        cartService.update(cart,good,count);
        System.out.println(cart);
        response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
    }
}
