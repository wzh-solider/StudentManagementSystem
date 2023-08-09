package com.solider.web.action;

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
 * 模板方法设计模式，解决类爆炸问题
 *
 * @author Solider
 * @version 1.0
 * @since 1.0
 */
@WebServlet({"/addStudent", "/delSelected", "/findStudent"})
public class StudentServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 解决乱码问题
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        // 获取servlet路径
        String servletPath = request.getServletPath();
        if ("/addStudent".equals(servletPath)) {
            // 添加学生方法
            doAddStudent(request, response);
        } else if ("/delSelected".equals(servletPath)) {
            // 删除学生数据方法
            doDelSelected(request, response);
        } else if ("/findStudent".equals(servletPath)) {
            // 查找学生方法
            doFindStudent(request, response);
        } else {
            // 路径出错
            response.sendRedirect(request.getContextPath() + "/function/error/pathError.jsp");
        }
    }


    private void doAddStudent(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        StudentService studentService = new StudentServiceImpl();

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

    private void doDelSelected(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        StudentService studentService = new StudentServiceImpl();
        String[] ids = request.getParameterValues("checkbox");

        if (ids != null && ids.length != 0) {
            studentService.delSelected(ids);
        }

        // 重定向
        response.sendRedirect(request.getContextPath() + "/signIn/successful.jsp");
    }

    private void doFindStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentService studentService = new StudentServiceImpl();
        response.setContentType("text/html; charset=UTF-8");

        String name = request.getParameter("name");
        List<Student> students = studentService.studentByName(name);
        request.setAttribute("students", students);

        // 请求转发
        request.getRequestDispatcher("/function/query.jsp").forward(request, response);
    }
}
