package com.solider.web;

import com.solider.bean.Student;
import com.solider.service.StudentService;
import com.solider.service.impl.StudentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * @author Solider
 * @version 1.0
 * @since 1.0
 */
@WebServlet("/findStudent")
public class FindStudentServlet extends HttpServlet {
    private StudentService studentSrevice;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        studentSrevice = new StudentServiceImpl();
        response.setContentType("text/html; charset=UTF-8");
        String contextPath = request.getContextPath();


        String name = request.getParameter("name");
        List<Student> students = studentSrevice.studentByName(name);
        request.setAttribute("students", students);

        // 转发
        request.getRequestDispatcher("/function/query.jsp").forward(request, response);
    }
}
