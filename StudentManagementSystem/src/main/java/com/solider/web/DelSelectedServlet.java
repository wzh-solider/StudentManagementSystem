package com.solider.web;

import com.solider.service.StudentService;
import com.solider.service.impl.StudentServiceImpl;
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
@WebServlet("/delSelected")
public class DelSelectedServlet extends HttpServlet {
    StudentService studentService = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        studentService = new StudentServiceImpl();
        String[] ids = request.getParameterValues("checkbox");

        if (ids != null && ids.length != 0) {
            studentService.delSelected(ids);
        }

        // 重定向
        response.sendRedirect(request.getContextPath() + "/signIn/successful.jsp");
    }
}
