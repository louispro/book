package com.louis.web;

import com.louis.bean.Cart;
import com.louis.bean.Order;
import com.louis.bean.OrderItem;
import com.louis.bean.User;
import com.louis.dao.impl.BaseDao;
import com.louis.service.impl.CartServiceImpl;
import com.louis.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class OrderServlet extends BaseServlet {

    private OrderServiceImpl orderService = new OrderServiceImpl();
    private CartServiceImpl cartService = new CartServiceImpl();

    /**
     * 结账的同时清空购物车
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User)session.getAttribute("user");
        //生成订单号
        String orderId = UUID.randomUUID().toString();
        request.setAttribute("orderId",orderId);
        orderService.createOrder(cart,user.getId(),orderId);
        //生成订单之后结账并且清空购物车
        cartService.clear(cart);
        request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request,response);
    }

    protected void showAllOrders(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = orderService.showAllOrders();
        request.setAttribute("orders",orders);
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request,response);
    }

    protected void sendOrder(HttpServletRequest request,HttpServletResponse response) throws IOException {
        orderService.sendOrder(request.getParameter("orderId"));
        response.sendRedirect(request.getContextPath()+"/order?action=showAllOrders");
    }

    protected void showOrderDetail(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<OrderItem> orderItems = orderService.showOrdetDetail(request.getParameter("orderId"));
        request.setAttribute("orderItems",orderItems);
        request.getRequestDispatcher("/pages/order/orderItem.jsp").forward(request,response);
    }

    protected void showMyOrders(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        List<Order> orders = orderService.showOrdersByUserId(user.getId());
        request.setAttribute("orders",orders);
        request.getRequestDispatcher("/pages/order/order.jsp").forward(request,response);
    }
}
