package com.solider.web;

import com.solider.exception.ApplicationException;
import com.solider.mapper.UserMapper;
import com.solider.service.UserService;
import com.solider.service.impl.UserServiceImpl;
import com.solider.utils.SqlSessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Solider
 * @version 1.0
 * @since 1.0
 */
@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            // 提交数据，关闭连接
            if (userService.signUp(request, response)) {
                // response.getWriter().println("注册成功");
                // 如果注册成功，自动登录
                SqlSessionUtil.openSession().commit();
                response.sendRedirect("signIn/successful.jsp");
            } else {
                // response.getWriter().println("注册失败");
                response.sendRedirect("signUp/failed.jsp");
            }
        } catch (RuntimeException e) {
            throw new ApplicationException(e.getMessage());
        } finally {
            SqlSessionUtil.close();
        }
    }

}
