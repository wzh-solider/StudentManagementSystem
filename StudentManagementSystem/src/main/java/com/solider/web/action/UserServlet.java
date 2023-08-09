package com.solider.web.action;

import com.solider.bean.User;
import com.solider.service.UserService;
import com.solider.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author Solider
 * @version 1.0
 * @since 2.0
 */
@WebServlet({"/signIn", "/signUp"})
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 解决乱码问题
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        // 获取Servlet路径
        String servletPath = request.getServletPath();

        if ("/signIn".equals(servletPath)) {
            // 登录服务
            doSignIn(request, response);
        } else if ("/signUp".equals(servletPath)) {
            // 注册服务
            doSignUp(request, response);
        } else {
            // 路径出错
            response.sendRedirect(request.getContextPath() + "/function/error/pathError.jsp");
        }
    }

    private void doSignIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserService userService = new UserServiceImpl();

        // 获取项目的根路径
        String contextPath = request.getServletContext().getContextPath();

//        try {
//            // 登录验证
//            if (userService.checkUser(request, response) != null) {
//                response.sendRedirect(contextPath + "/signIn/successful.jsp");
//            } else {
//                // response.getWriter().write("登录失败");
//                response.sendRedirect(contextPath + "/signIn/failed.jsp");
//            }
//        } catch (RuntimeException | IOException e) {
//            throw new ApplicationException(e.getMessage());
//        } finally {
//            SqlSessionUtil.close();
//        }

        // 获取参数
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // 获取会话对象
        HttpSession session = request.getSession();

        // 参数验证登录
        if (userService.checkUser(email, password) != null) {
            // 如果登录成功，将用户信息保存到session会话对象中
            session.setAttribute("email", email);
            // 重定向到成功页面
            response.sendRedirect(contextPath + "/signIn/successful.jsp");
        } else {
            // 登录失败，重定向到失败页面
            response.sendRedirect(contextPath + "/signIn/failed.jsp");
        }

    }

    private void doSignUp(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        UserService userService = new UserServiceImpl();

//        try {
//            // 提交数据，关闭连接
//            if (userService.signUp(request, response)) {
//                // response.getWriter().println("注册成功");
//                // 如果注册成功，自动登录
//                SqlSessionUtil.openSession().commit();
//                response.sendRedirect("signIn/successful.jsp");
//            } else {
//                // response.getWriter().println("注册失败");
//                response.sendRedirect("signUp/failed.jsp");
//            }
//        } catch (RuntimeException | IOException e) {
//            throw new ApplicationException(e.getMessage());
//        } finally {
//            SqlSessionUtil.close();
//        }

        // 获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        if (userService.signUp(new User(username, password, email))) {
            response.sendRedirect("signIn/successful.jsp");
        } else {
            response.sendRedirect("signUp/failed.jsp");
        }
    }
}
