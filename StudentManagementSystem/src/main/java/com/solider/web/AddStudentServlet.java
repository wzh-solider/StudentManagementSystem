package com.solider.web;

import com.solider.bean.Student;
import com.solider.exception.AddStudentException;
import com.solider.service.StudentService;
import com.solider.service.impl.StudentServiceImpl;
import com.solider.utils.SqlSessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 增加学生信息
 *
 * @author Solider
 * @version 1.0
 * @since 1.0
 */
@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    StudentService studentService = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        studentService = new StudentServiceImpl();

        response.setContentType("text/html; charset=UTF-8");

        String contextPath = request.getContextPath();

        // 获取参数
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        Integer age = Integer.parseInt(request.getParameter("age"));
        String grade = request.getParameter("grade");

        Student student = new Student(null, name, age, sex, grade);

        studentService.addStudent(student);

        // 列表
        response.sendRedirect(contextPath + "/signIn/successful.jsp");

    }
}