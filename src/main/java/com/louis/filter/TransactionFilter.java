package com.louis.filter;

import com.louis.utils.JDBCUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            System.out.println("事务完毕，准备提交");
            JDBCUtils.commitAndClose();// 提交事务
            System.out.println("提交完毕");
        } catch (Exception e) {
            JDBCUtils.rollbackAndClose();//回滚事务
            System.out.println("事务操作失败");
            e.printStackTrace();
            throw new RuntimeException(e);//把异常抛给Tomcat管理展示友好的错误页面
        }
    }

    @Override
    public void destroy() {
    }
}
