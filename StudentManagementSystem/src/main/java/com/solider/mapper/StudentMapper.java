package com.solider.mapper;

import com.solider.bean.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Solider
 * @version 1.0
 * @since 1.0
 */
public interface StudentMapper {

    @Select("select * from t_student")
    List<Student> selectAll();

    @Select("select * from t_student where name = #{name}")
    List<Student> selectByName(@Param("name") String name);

    @Insert("insert into t_student (id, name, age, sex, grade) values (#{id}, #{name}, #{age}, #{sex}, #{grade})")
    int insertStudent(Student student);

    @Delete("delete from t_student where id = #{id}")
    int deleteById(Integer id);
}
