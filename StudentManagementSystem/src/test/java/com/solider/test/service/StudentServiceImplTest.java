package com.solider.test.service;

import com.solider.service.StudentService;
import com.solider.service.impl.StudentServiceImpl;
import org.junit.Test;

/**
 * @author Solider
 * @version 1.0
 * @since 1.0
 */
public class StudentServiceImplTest {

    @Test
    public void testStudentByName() {
        StudentService studentService = new StudentServiceImpl();
        System.out.println(studentService.studentByName("张三"));
    }

    @Test
    public void testStudentList() {
        StudentServiceImpl studentService = new StudentServiceImpl();
        System.out.println(studentService.studentList());
    }
}
