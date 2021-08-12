package com.louis.web;

import com.louis.bean.User;
import com.louis.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.login(new User(null,username,password,null));
        if(user==null){
            request.setAttribute("msg","用户名或密码错误");
            request.setAttribute("username",username);
            request.setAttribute("password",password);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }
    }
}
