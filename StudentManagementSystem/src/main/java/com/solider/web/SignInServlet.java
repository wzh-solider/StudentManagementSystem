package com.solider.web;

import com.solider.exception.ApplicationException;
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
@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 获取项目的根路径
        String contextPath = request.getServletContext().getContextPath();

        try {
            // 登录验证
            if (userService.checkUser(request, response) != null) {
                response.sendRedirect(contextPath + "/signIn/successful.jsp");
            } else {
                // response.getWriter().write("登录失败");
                response.sendRedirect(contextPath + "/signIn/failed.jsp");
            }
        } catch (RuntimeException e) {
            throw new ApplicationException(e.getMessage());
        } finally {
            SqlSessionUtil.close();
        }
    }
}
