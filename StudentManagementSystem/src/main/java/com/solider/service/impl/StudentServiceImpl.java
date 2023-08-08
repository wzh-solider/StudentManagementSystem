package com.solider.service.impl;

import com.solider.bean.Student;
import com.solider.exception.ExecutionErrorException;
import com.solider.mapper.StudentMapper;
import com.solider.service.StudentService;
import com.solider.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.*;
import java.util.logging.Logger;

/**
 * @author Solider
 * @version 1.0
 * @since 1.0
 */
public class StudentServiceImpl implements StudentService {

    private SqlSession sqlSession = null;
    private StudentMapper mapper = null;
    private static final Logger logger = Logger.getLogger("log");

    public StudentServiceImpl() {
        sqlSession = SqlSessionUtil.openSession();
        mapper = sqlSession.getMapper(StudentMapper.class);
    }

    @Override
    public List<Student> studentList() {
        List<Student> students = mapper.selectAll();
        SqlSessionUtil.close();
        return students;
    }

    @Override
    public List<Student> studentByName(String name) {
        List<Student> students = mapper.selectByName(name);
        SqlSessionUtil.close();
        return students;
    }

    @Override
    public void addStudent(Student student) {
        try {
            // 如果年龄超出范围，抛出异常
            if (student.getAge() < 0 || student.getAge() > 200) {
                throw new IllegalArgumentException("Student年龄出错");
            }

            // 执行到此，说明参数正确
            int count = mapper.insertStudent(student);
            if (count < 0) {
                throw new ExecutionErrorException();
            }
            sqlSession.commit();
        } catch (IllegalArgumentException e) {
            sqlSession.rollback();
            logger.info("参数出错");
        } catch (ExecutionErrorException e) {
            sqlSession.rollback();
            logger.info("添加学生，执行错误");
        } finally {
            SqlSessionUtil.close();
        }

    }

    @Override
    public void delSelected(String[] ids) {
        int count = 0;
        try {
            for (String id : ids) {
                count += mapper.deleteById(Integer.parseInt(id));
            }

            // 判断删除语句是否成功
            if (count != ids.length) {
                throw new ExecutionErrorException();
            }
            sqlSession.commit();
        } catch (ExecutionErrorException e) {
            // 如果抛出了异常，则回退
            sqlSession.rollback();
            logger.info("删除出错");
        } finally {
            SqlSessionUtil.close();
        }
    }

}
