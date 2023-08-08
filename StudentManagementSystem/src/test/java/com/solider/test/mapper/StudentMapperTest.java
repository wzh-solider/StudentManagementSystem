package com.solider.test.mapper;

import com.solider.bean.Student;
import com.solider.mapper.StudentMapper;
import com.solider.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author Solider
 * @version 1.0
 * @since 1.0
 */
public class StudentMapperTest {

    @Test
    public void testSelectAll() {
        StudentMapper mapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        List<Student> students = mapper.selectAll();
        students.forEach(student -> {
            System.out.println(student);
        });
        SqlSessionUtil.close();
    }

    @Test
    public void testInsertStudent() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setName("solider");
        student.setAge(18);
        student.setSex("男");
        student.setGrade("一年级");
        int count = mapper.insertStudent(student);
        if (count > 0) {
            System.out.println("插入成功");
            sqlSession.commit();
        }
        SqlSessionUtil.close();
    }
}
