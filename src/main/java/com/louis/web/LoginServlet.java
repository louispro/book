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
        String password = request.getParameter("passwrod");
        User user = userService.login(new User(null,username,password,null));
        if(user==null){
            request.getRequestDispatcher("/pages/user/login.html").forward(request,response);
        }else {
            request.getRequestDispatcher("/pages/user/login_success.html").forward(request,response);
        }
    }
}
