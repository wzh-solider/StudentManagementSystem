package com.solider.service;

import com.solider.bean.Student;
import com.solider.mapper.StudentMapper;
import com.solider.utils.SqlSessionUtil;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Solider
 * @version 1.0
 * @since 1.0
 */
public interface StudentService {

    /**
     * 返回学生信息列表
     * @return List<Student>
     */
    List<Student> studentList();

    /**
     *
     */
    List<Student> studentByName(String name);

    /**
     * 增加学生信息
     * @param student
     */
    void addStudent(Student student);

    /**
     * 删除选中信息
     * @param ids 删除学生信息的id
     */
    void delSelected(String[] ids);
}
