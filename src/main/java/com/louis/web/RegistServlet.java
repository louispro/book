package com.louis.web;

import com.louis.bean.User;
import com.louis.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        //验证码正确就检查用户名是否可用
        if("abcde".equalsIgnoreCase(code)){
            //验证用户名是否可用
            //可用
            if(userService.existsUsername(username)==false){
                userService.register(new User(null,username,password,email));
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
            }else{
                //不可用
                request.setAttribute("msg","用户名已存在");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            }
        }else{
            //验证码错误，重新注册
            request.setAttribute("msg","验证码错误");
            request.setAttribute("username",username);
            request.setAttribute("password",password);
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
        }
    }

}
