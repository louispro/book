package com.louis.web;

import com.louis.bean.User;
import com.louis.service.impl.UserServiceImpl;
import com.louis.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class UserServlet extends BaseServlet{

    private UserServiceImpl userService = new UserServiceImpl();

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                User user = WebUtils.copyParamsToBean(request.getParameterMap(),new User());
                userService.register(user);
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

    protected  void login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.login(WebUtils.copyParamsToBean(request.getParameterMap(),new User()));
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