package com.louis.web;

import com.google.gson.Gson;
import com.louis.bean.Cart;
import com.louis.bean.User;
import com.louis.service.impl.UserServiceImpl;
import com.louis.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class UserServlet extends BaseServlet{

    private UserServiceImpl userService = new UserServiceImpl();

    //验证用户名是否存在
    protected void ajaxExistUsername(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String username =  request.getParameter("username");
        System.out.println(username);
        boolean existUsername = userService.existsUsername(username);
        System.out.println(existUsername);
        Map<String,Boolean> resultMap = new HashMap<>();
        resultMap.put("existUsername",existUsername);
        Gson gosn = new Gson();
        String json = gosn.toJson(resultMap);
        response.getWriter().write(json);
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session中的验证码
        String token = (String)request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        System.out.println(token);
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        //验证码正确就检查用户名是否可用
        if(token.equalsIgnoreCase(code)){
            //可用
            User user = WebUtils.copyParamsToBean(request.getParameterMap(),new User());
            user.setCartId(UUID.randomUUID().toString());
            userService.register(user);
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
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
            Cart cart = userService.getCart(user.getCartId());
            HttpSession session = request.getSession();
            session.setAttribute("user",user);  // 将用户信息保存到session中
            session.setAttribute("cart",cart);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }
    }

    protected void logout(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.getSession().invalidate();  //注销session信息
        response.sendRedirect(request.getContextPath()+"/pages/user/login.jsp");
    }
}
